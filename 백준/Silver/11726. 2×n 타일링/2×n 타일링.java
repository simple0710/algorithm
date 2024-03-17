import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= N; i++) dp[i] = (dp[i-1] + dp[i-2]) % 10_007;
		System.out.print(dp[N]);
	}
}