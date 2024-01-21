import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, res = 1;
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
	static int[][] board, dp;
	static boolean flag;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] row = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				board[i][j] = row[j].equals("H") ? 0 : Integer.parseInt(row[j]);
			}
		}
		visited = new boolean[N][M];
		dp = new int[N][M];
		visited[0][0] = true;
		find(0, 0, 1);
		System.out.print(flag ? -1 : res);
	}

	public static void find(int x, int y, int cnt) {
		res = Math.max(res, cnt);
		dp[x][y] = cnt;
		for (int d = 0; d < 4; d++) {
			int nx = x + board[x][y] * dx[d];
			int ny = y + board[x][y] * dy[d];
			if (0 <= nx && nx < N && 0 <= ny && ny < M && board[nx][ny] != 0) {
				if (visited[nx][ny]) {
					flag = true;
					return;
				}
				if (dp[nx][ny] > cnt) continue;
				visited[nx][ny] = true;
				find(nx, ny, cnt + 1);
				visited[nx][ny] = false;
			}
		}
	}
}