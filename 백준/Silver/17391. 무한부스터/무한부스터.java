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
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] board = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.print(bfs(board, N, M));
	}
	
	public static int bfs(int[][] board, int N, int M) {
		int[] dx = {1, 0}, dy = {0, 1};
		int[][] visited = new int[N][M];
		Deque<Place> q = new LinkedList<>();
		q.add(new Place(0, 0));
		visited[0][0] = 1;
		while (!q.isEmpty()) {
			Place now = q.poll();
			for (int i = 0; i < 2; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				while (0 <= nx && nx < N && 0 <= ny && ny < M) {
					if (Math.abs(nx - now.x) + Math.abs(ny - now.y) > board[now.x][now.y]) break;
					if (visited[nx][ny] == 0) {
						q.add(new Place(nx, ny));
						visited[nx][ny] = visited[now.x][now.y] + 1;
					}
					nx += dx[i];
					ny += dy[i];
				}
			}
		}
		return visited[N-1][M-1] - 1;
	}
}