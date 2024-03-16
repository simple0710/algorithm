import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] stairs = new int[N+2];
		int[][] dp = new int[2][N+2];
		for (int i = 2; i < N+2; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
			dp[0][i] = stairs[i] + dp[1][i-1];
			dp[1][i] = stairs[i] + Math.max(dp[0][i-2], dp[1][i-2]);
		}
		System.out.print(Math.max(dp[0][N+1], dp[1][N+1]));
	}
}