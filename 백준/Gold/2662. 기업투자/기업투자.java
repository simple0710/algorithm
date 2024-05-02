import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int[][] nums = new int[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			input = br.readLine().split(" ");
			for (int j = 1; j <= M; j++) nums[i][j]= Integer.parseInt(input[j]);
		}
		int[][] dp = new int[M+1][N+1];
		int[][] invest = new int[M+1][N+1];
		for (int i = 1; i <= M; i++) {
			for (int j = 0; j <= N; j++) {
				for (int k = N - j; k >= 0; k--) {
					if (dp[i][j+k] < dp[i-1][k] + nums[j][i]) {
						dp[i][j+k]= dp[i-1][k] + nums[j][i];
						invest[i][j+k] = j;
					}
				}
			}
		}
		int[] res = new int[M+1];
		getRes(res, invest, N, M);
		System.out.println(dp[M][N]);
		for (int i = 1; i <= M; i++) System.out.print(res[i] + " ");
	}
	static void getRes(int[] res, int[][] invest, int n, int m) {
		if (m == 0) return;
		res[m] = invest[m][n];
		getRes(res, invest, n - res[m], m - 1);
	}
}