import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split(" ");
			int M = Integer.parseInt(br.readLine());
			int[] dp = new int[M+1];
			dp[0] = 1;
			for (int i = 0; i < N; i++) {
				int now = Integer.parseInt(str[i]);
				for (int j = now; j <= M; j++) {
					dp[j] += dp[j-now];
				}
			}
			System.out.println(dp[M]);
		}
	}
}