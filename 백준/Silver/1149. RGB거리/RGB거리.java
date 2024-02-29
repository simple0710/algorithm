import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[3][N+1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) dp[j][i] = Math.min(dp[(j+1)%3][i-1], dp[(j+2)%3][i-1]) + Integer.parseInt(st.nextToken());
		}
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) res = Math.min(res, dp[i][N]);
		System.out.print(res);
	}
}