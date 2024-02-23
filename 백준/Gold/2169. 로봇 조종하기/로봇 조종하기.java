import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] board = new int[N + 1][M + 2];
		int[][] dp = new int[N + 1][M + 2];
		int[][] ltr = new int[N + 1][M + 2];
		int[][] rtl = new int[N + 1][M + 2];
		for (int i = 1; i <= N; i++) { 
			Arrays.fill(dp[i], -Integer.MAX_VALUE);
			Arrays.fill(ltr[i], -Integer.MAX_VALUE);
			Arrays.fill(rtl[i], -Integer.MAX_VALUE);
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
			
		ltr[1][0] = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				ltr[i][j] = Math.max(i == 1 ? ltr[i][j-1] : dp[i-1][j], ltr[i][j-1]) + board[i][j];
				if (i != 1) rtl[i][M+1-j] = Math.max(dp[i-1][M+1-j], rtl[i][M+1-j+1]) + board[i][M+1-j];
			}
			for (int j = 1; j <= M; j++) dp[i][j] = Math.max(ltr[i][j], rtl[i][j]);
		}
		System.out.print(dp[N][M]);
	}
}