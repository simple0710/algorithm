import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] day = new int[N+1][2];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken()) - 1;
			int P = Integer.parseInt(st.nextToken());
			day[i][0] = T;
			day[i][1] = P;
		}
		int[] dp = new int[N + 2];
		for (int i = N; i > 0; i--) {
			if (i + day[i][0] <= N) dp[i] = Math.max(dp[i+1], dp[i+day[i][0]+1] + day[i][1]);
			else dp[i] = dp[i+1];
		}
		System.out.print(dp[1]);
	}
}