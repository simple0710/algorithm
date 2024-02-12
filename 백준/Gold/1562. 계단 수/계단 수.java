import java.io.*;

public class Main {
	static final int MOD = 1000000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][][] dp = new long[101][10][1024];
		for (int i = 1; i < 10; i++) dp[1][i][1<<i] = 1L;
		for (int i = 1; i < 101; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 1024; k++) {
					int bit = k | (1 << j);
					if (j == 0) {
						dp[i][j][bit] += dp[i-1][j+1][k];
					} else if (j == 9) {
						dp[i][j][bit] += dp[i-1][j-1][k];
					} else {
						dp[i][j][bit] += dp[i-1][j-1][k] + dp[i-1][j+1][k];
					}
					dp[i][j][bit] %= MOD;
				}
			}
		}
		long res = 0;
		for (int i = 0; i < 10; i++) res = (res + dp[N][i][1023]) % MOD;
		System.out.print(res);
	}
}