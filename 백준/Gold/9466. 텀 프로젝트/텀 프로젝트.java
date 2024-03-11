import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] arr, team;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[N+1];
			team = new int[N+1];
			for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());
			int res = 0;
			for (int i = 1; i <= N; i++) {
				if (team[i] == 0) dfs(i);
				if (team[i] == 3) res++;
			}
			sb.append(res).append("\n");
		}
		System.out.print(sb);
	}
	
	public static void dfs(int now) {
		team[now]++;
		if (team[arr[now]] < 2) dfs(arr[now]);
		if (team[now] == 1) team[now] = 3;
	}
}