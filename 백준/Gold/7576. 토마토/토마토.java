import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int N, M, startX, startY;
	static int[][] board, visited;
	static ArrayList<Place> list;

	public static class Place {
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
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		board = new int[N][M];
		visited = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1) {
					list.add(new Place(i, j));
				}
			}
		}
		System.out.print(bfs());
	}

	public static int bfs() {
		int res = 1;
		int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
		Deque<Place> q = new LinkedList<>();
		for (int i = 0; i < list.size(); i++) {
			int x = list.get(i).x;
			int y = list.get(i).y;
			q.add(new Place(x, y));
			visited[x][y] = 1;
		}
		while (!q.isEmpty()) {
			Place now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < M && board[nx][ny] == 0 && visited[nx][ny] == 0) {
					q.add(new Place(nx, ny));
					visited[nx][ny] = visited[now.x][now.y] + 1;
					res = Math.max(res, visited[nx][ny]);
				}
			}
		}
		boolean flag = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] != -1 && visited[i][j] == 0) {
					flag = true;
				}
			}
		}
		return flag ? -1 : res - 1;
	}
}