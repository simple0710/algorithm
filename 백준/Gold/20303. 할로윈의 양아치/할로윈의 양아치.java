import java.io.*;
import java.util.*;

public class Main {
	static int[] parent, kidsCnt, candyCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		parent = new int[N + 1];
		kidsCnt = new int[N + 1];
		candyCnt = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			candyCnt[i] += Integer.parseInt(st.nextToken());
			kidsCnt[i] = 1;
		}
		for (int i = 1; i <= N; i++)
			parent[i] = i;
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		for (int i = N; i >= 0; i--) dataChange(i);
		int[][] dp = new int[N + 1][K];
		for (int i = 1; i <= N; i++) {
			for (int k = 1; k < K; k++) {
				if (k - kidsCnt[i] < 0) dp[i][k] = dp[i - 1][k];
				else dp[i][k] = Math.max(dp[i - 1][k], dp[i - 1][k - kidsCnt[i]] + candyCnt[i]);
			}
		}
		System.out.print(dp[N][K - 1]);
	}

	public static int find(int x) {
		if (x != parent[x]) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		parent[Math.max(a, b)] = Math.min(a, b);
	}

	public static void dataChange(int v) {
		int newParent = find(v);
		if (newParent == v) return;
		candyCnt[newParent] += candyCnt[v];
		kidsCnt[newParent] += kidsCnt[v];
		candyCnt[v] = 0;
		kidsCnt[v] = 0;
	}
}