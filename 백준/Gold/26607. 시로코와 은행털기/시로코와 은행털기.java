import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		int X = Integer.parseInt(input[2]);
		int MAX = K * X;
		boolean[][] dp = new boolean[K + 1][MAX + 1];
		dp[0][0] = true;
		while (N-- > 0) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			for (int i = K; i >= 2; i--) {
				for (int j = a; j <= MAX; j++) {
					dp[i][j] = dp[i][j] || dp[i - 1][j - a];
				}
			}
			dp[1][a] = true;
		}
		int res = 0;
		for (int i = 1; i <= MAX; i++) {
			if (dp[K][i]) res = Math.max(res, i * (MAX - i));
		}
		System.out.print(res);
	}
}