import java.io.*;

public class Main {
	static int MAX = 100_001;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int C = Integer.parseInt(str[0]);
		int N = Integer.parseInt(str[1]);
		int[] dp = new int[MAX];
		while (N-- > 0) {
			str = br.readLine().split(" ");
			int cost = Integer.parseInt(str[0]);
			int guest = Integer.parseInt(str[1]);
			for (int i = cost; i < MAX; i++) dp[i] = Math.max(dp[i], dp[i-cost] + guest);
		}
		for (int i = 0; i < MAX; i++) {
			if (dp[i] >= C) {
				System.out.print(i);
				break;
			}
		}
	}
}
