import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] dp = new int[K + 1];
		Arrays.fill(dp, 1000000);
		dp[A] = 0;
		for (int i = A+1; i < K + 1; i++) {
			dp[i] = Math.min(dp[i-1], dp[i/2] + i%2) + 1;
		}
		System.out.print(dp[K]);
	}
}