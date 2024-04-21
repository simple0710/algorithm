import java.io.*;
import java.util.*;

public class Main {
	static int cnt = 1;
	static int[] res;
	static ArrayList<Integer>[] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]), M = Integer.parseInt(str[1]), R = Integer.parseInt(str[2]);
		graph = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
		while (M-- > 0) {
			str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]), b = Integer.parseInt(str[1]);
			graph[a].add(b);
			graph[b].add(a);
		}
		for (int i = 1; i <= N; i++) Collections.sort(graph[i], Collections.reverseOrder());
		res = new int[N+1];
		dfs(R);
		for (int now = 1; now <= N; now++) System.out.println(res[now]);
	}
	private static void dfs(int now) {
		if (res[now] != 0) return;
		res[now] = cnt++;
		for (int next : graph[now]) dfs(next);
	}
}