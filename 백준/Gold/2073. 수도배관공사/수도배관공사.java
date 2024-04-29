import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int D = Integer.parseInt(input[0]);
		int P = Integer.parseInt(input[1]);
		int[] dp = new int[D+1];
		dp[0] = Integer.MAX_VALUE;
		while (P-- > 0) {
			input = br.readLine().split(" ");
			int L = Integer.parseInt(input[0]);
			int C = Integer.parseInt(input[1]);
			for (int i = D; i >= L; i--) dp[i] = Math.max(dp[i], Math.min(dp[i-L], C));
		}
		System.out.print(dp[D]);
	}
}