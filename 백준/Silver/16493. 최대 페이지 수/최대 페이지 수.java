import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int[] dp = new int[N+1];
		while (M-- > 0) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			for (int i = N; i >= a; i--) dp[i] = Math.max(dp[i], dp[i-a] + b);
		}
		System.out.print(dp[N]);
	}
}