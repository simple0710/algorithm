import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		int[] dp = new int[K+1];
		for (int i = 1; i <= K; i++) dp[i] = N + 1;
		input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			int c = Integer.parseInt(input[i]);
			for (int j = K; j >= c; j--) dp[j] = Math.min(dp[j], dp[j-c] + 1);
		}
		System.out.print(dp[K] == N + 1 ? -1 : dp[K]);
	}
}