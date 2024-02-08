import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] data = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			data[i][0] = T;
			data[i][1] = P;
		}
		int[] dp = new int[N + 1];
		for (int i = N-1; i >= 0; i--) {
			if (i + data[i][0] > N) {
				dp[i] = dp[i+1];
			} else {
				dp[i] = Math.max(dp[i+1], data[i][1] + dp[i+data[i][0]]);
			}
		}
		System.out.print(dp[0]);
	}
}