import java.io.*;
import java.util.*;

public class Main {
	static class Place {
		int x;
		int y;

		Place(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int L, nowX, nowY, goalX, goalY;
	static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			L = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			nowX = Integer.parseInt(st.nextToken());
			nowY = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			goalX = Integer.parseInt(st.nextToken());
			goalY = Integer.parseInt(st.nextToken());
			System.out.println(bfs());
		}
	}

	public static int bfs() {
		int[] dx = new int[] { -1, -2, -2, -1, 1, 2, 2, 1 }, dy = new int[] { -2, -1, 1, 2, 2, 1, -1, -2 };
		Deque<Place> q = new LinkedList<>();
		int[][] visited = new int[L][L];
		visited[nowX][nowY] = 1;
		q.add(new Place(nowX, nowY));
		while (!q.isEmpty()) {
			Place now = q.poll();
			for (int i = 0; i < 8; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (0 <= nx && nx < L && 0 <= ny && ny < L && visited[nx][ny] == 0) {
					visited[nx][ny] = visited[now.x][now.y] + 1;
					q.add(new Place(nx, ny));
				}
			}
		}
		return visited[goalX][goalY] - 1;
	}
}