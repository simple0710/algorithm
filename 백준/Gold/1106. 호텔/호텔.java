import java.io.*;

public class Main {
	static int MAX;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int C = Integer.parseInt(str[0]);
		int N = Integer.parseInt(str[1]);
		MAX = C+101;
		int[] dp = new int[MAX];
		for (int i = 1; i < MAX; i++) dp[i] = 1000 * MAX;
		while (N-- > 0) {
			str = br.readLine().split(" ");
			int cost = Integer.parseInt(str[0]);
			int guest = Integer.parseInt(str[1]);
			for (int i = guest; i < MAX; i++) dp[i] = Math.min(dp[i], dp[i-guest] + cost);
		}
		int res = 1000*MAX;
		for (int i = C; i < MAX; i++) res = Math.min(res, dp[i]);
		System.out.print(res);
	}
}