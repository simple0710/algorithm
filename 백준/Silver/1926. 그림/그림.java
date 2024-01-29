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
	static int N, M;
	static int[][] board;
	static boolean[][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int resCnt = 0;
		int resMaxArea = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 1 && !visited[i][j]) {
					resCnt++;
					resMaxArea = Math.max(resMaxArea, bfs(i, j));
				}
			}
		}
		System.out.println(resCnt);
		System.out.print(resMaxArea);
	}
	public static int bfs(int x, int y) {
		int[] dx = new int[] {-1, 1, 0, 0};
		int[] dy = new int[] {0, 0, -1, 1};
		Deque<Place> q = new LinkedList<>();
		q.add(new Place(x, y));
		int cnt = 1;
		visited[x][y] = true;
		while (!q.isEmpty()) {
			Place now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < M && board[nx][ny] == 1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					cnt++;
					q.add(new Place(nx, ny));
				}
			}
		}
		return cnt;
	}
}