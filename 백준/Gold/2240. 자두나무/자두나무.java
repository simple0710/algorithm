import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken()) + 1;
		int W = Integer.parseInt(st.nextToken()) + 2;
		int[][][] dp = new int[3][T][W];
		int[][] trees = new int[3][T];
		int res = 0;
		for (int t = 1; t < T; t++) {
			trees[Integer.parseInt(br.readLine())][t] = 1;
			for (int w = 1; w < W; w++) {
				for (int now = 1; now <= 2; now++) {
					if (now == 2 && t == 1 && w == 1) continue;
					dp[now][t][w] = Math.max(dp[now][t-1][w], dp[3-now][t-1][w-1]) + trees[now][t];
					res = Math.max(res, dp[now][t][w]);
				}
			}
		}
		System.out.print(res);
	}
}