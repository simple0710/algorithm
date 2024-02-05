import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] dx = new int[]{-1, 1, 0, 0}, dy = new int[]{0, 0, -1, 1};
	static boolean[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			board = new boolean[N][M];
			while (K-- > 0) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				board[x][y] = true;
			}
			int res = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (board[i][j]) {
						board[i][j] = false;
						dfs(i, j);
						res++;
					}
				}
			}
			System.out.println(res);
		}
	}

	public static void dfs(int x, int y) {
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (0 <= nx && nx < N && 0 <= ny && ny < M && board[nx][ny]) {
				board[nx][ny] = false;
				dfs(nx, ny);
			}
		}
	}
}