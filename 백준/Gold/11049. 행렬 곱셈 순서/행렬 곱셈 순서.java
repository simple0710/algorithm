import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N][N];
		int[][] num = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			num[i][0] = Integer.parseInt(st.nextToken());
			num[i][1] = Integer.parseInt(st.nextToken());
		}
		for (int k = 1; k < N; k++) {
			for (int i = 0; i+k < N; i++) {
				dp[i][i+k] = Integer.MAX_VALUE;
				for (int j = i; j < i+k; j++) {
					dp[i][i+k] = Math.min(dp[i][i+k], dp[i][j] + dp[j+1][i+k] + num[i][0] * num[j][1] * num[i+k][1]);
				}
			}
		}
		System.out.print(dp[0][N-1]);
	}
}