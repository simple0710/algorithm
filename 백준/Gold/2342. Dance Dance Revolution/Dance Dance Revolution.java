import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		int now;
		while ((now = Integer.parseInt(st.nextToken())) != 0) list.add(now);
		int[][][] dp = new int[list.size() + 1][5][5];
		dp[0][0][0] = 1;
		for (int t = 1; t <= list.size(); t++) {
			now = list.get(t-1);
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (dp[t-1][i][j] != 0) {
						if (now != j) {
							int power1 = getPower(i, now);
							dp[t][now][j] = Math.min(dp[t][now][j] == 0 ? Integer.MAX_VALUE : dp[t][now][j], dp[t-1][i][j] + power1);
						}
						if (now != i) {
							int power2 = getPower(j, now);
							dp[t][i][now] = Math.min(dp[t][i][now] == 0 ? Integer.MAX_VALUE : dp[t][i][now], dp[t-1][i][j] + power2);
						}
					}
				}
			}
		}
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (dp[list.size()][i][j] != 0) {
					res = Math.min(res, dp[list.size()][i][j] - 1);
				}
			}
		}
		System.out.print(res);
	}

	private static int getPower(int foot, int now) {
		if (foot == now) return 1;
		else if (foot == 0) return 2;
		else if (Math.abs(foot - now) == 3 || Math.abs(foot - now) == 1) return 3;
		return 4;
	}
}