import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dp = new int[N+1];
		int res = -1000;
		for (int i = 1; i <= N; i++) {
			dp[i] = Math.max(0, dp[i-1]) + Integer.parseInt(st.nextToken());;
			res = Math.max(res, dp[i]);
		}
		System.out.print(res);
	}
}