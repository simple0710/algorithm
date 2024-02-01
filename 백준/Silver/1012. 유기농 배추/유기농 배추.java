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
	static int N, M, K;
	static boolean[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			board = new boolean[N][M];
			while (K-- > 0) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				board[Y][X] = true;
			}
			int res = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (board[i][j]) {
						res++;
						bfs(i, j);
					}
				}
			}
			System.out.println(res);
		}
	}

	public static void bfs(int x, int y) {
		int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
		Deque<Place> q = new LinkedList<>();
		q.add(new Place(x, y));
		board[x][y] = false;
		while (!q.isEmpty()) {
			Place now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < M && board[nx][ny]) {
					board[nx][ny] = false;
					q.add(new Place(nx, ny));
				}
			}
		}
	}
}