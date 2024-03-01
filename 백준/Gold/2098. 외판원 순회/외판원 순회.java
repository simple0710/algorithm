import java.io.*;
import java.util.*;

public class Main {
	static final int MAX = 16_000_000;
	static int N;
	static int[][] board, dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp = new int[N][1 << N];
		System.out.print(dfs(0, 1));
	}
	
	private static int dfs(int now, int visitBit) {
		if (visitBit == (1 << N) - 1) {
			if (board[now][0] == 0) {
				return MAX;
			}
			return board[now][0];
		}
		if (dp[now][visitBit] > 0) {
			return dp[now][visitBit];
		}
		dp[now][visitBit] = MAX;
		for (int i = 0; i < N; i++) {
			if ((visitBit & (1 << i)) == 0 && board[now][i] != 0) {
				dp[now][visitBit] = Math.min(dp[now][visitBit], dfs(i, visitBit | (1 << i)) + board[now][i]);
			}
		}
		return dp[now][visitBit];
	}
}