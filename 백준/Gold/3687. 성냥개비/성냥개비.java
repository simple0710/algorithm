import java.io.*;
import java.util.*;

public class Main {
	static int[] arr = new int[]{ 6, 2, 5, 5, 4, 5, 6, 3, 7, 6 };
	static int[] newArr = new int[] {};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		long[] dp = new long[101];
		Arrays.fill(dp, Long.MAX_VALUE);
		String[] add = {"1", "7", "4", "2", "0", "8"};
		dp[2] = 1;
		dp[3] = 7;
		dp[4] = 4;
		dp[5] = 2;
		dp[6] = 6;
		dp[7] = 8;
		dp[8] = 10;
		for (int i = 9; i <= 100; i++) {
			for (int j = 2; j <= 7; j++) {
				String line = dp[i-j] + add[j-2];
				dp[i] = Math.min(Long.parseLong(line), dp[i]);
			}
		}
		
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n]).append(" ").append(getMax(n)).append("\n");
		}
		System.out.println(sb);
	}
	
	public static String getMax(int n) {
		String max = "";
		if (n%2 != 0) {
			max = "7";
			n-=3;
		}
		while ((n-=2) >= 0) max += "1";   
		return max;
	}
	
	public static boolean isLong(String a, String b) {
		return a.length() > b.length();
	}
}