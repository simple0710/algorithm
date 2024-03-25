import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][] dp = new long[2][N];
		dp[1][0] = 1;
		for (int i = 1; i < N; i++) {
			dp[0][i] = dp[0][i-1] + dp[1][i-1];
			dp[1][i] = dp[0][i-1];
		}
		System.out.print(dp[0][N-1] + dp[1][N-1]);
	}
}