import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i-1] + 1;
			if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
			if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
		}
		System.out.println(dp[N]);
		int now = N;
		System.out.print(N + " ");
		for (int i = N; i > 0; i--) {
			if (dp[now] - 1 == dp[i] && ((now % 2 == 0 && now/2 == i) || (now%3 == 0 && now/3 == i) || now-1 == i)) {
				now = i;
				System.out.print(i + " ");
			}
		}
	}
}