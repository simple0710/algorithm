import java.io.*;

public class Main {
	static final int MOD = 10_007;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int H = Integer.parseInt(input[2]);
		int[][] dp = new int[N+1][H+1];
		dp[0][0] = 1;
		for (int i = 1; i <= N; i++) {
			input = br.readLine().split(" ");
			for (int k = 0; k <= H; k++) {
				dp[i][k] = dp[i-1][k];
			}
			for (int j = 0; j < input.length; j++) {
				int now = Integer.parseInt(input[j]);
				for (int k = now; k <= H; k++) {
					dp[i][k] = (dp[i][k] + dp[i-1][k-now]) % MOD;
				}
			}
		}
		System.out.print(dp[N][H] % MOD);
	}
}