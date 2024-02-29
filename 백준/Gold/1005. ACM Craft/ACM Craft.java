import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static long[] buildTime;
	static ArrayList<Integer>[] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			buildTime = new long[N+1];
			st = new StringTokenizer(br.readLine());
			graph = new ArrayList[N+1];
			for (int i = 1; i <= N; i++) {
				buildTime[i] = Integer.parseInt(st.nextToken());
				graph[i] = new ArrayList<>();
			}
			int[] inDegree = new int[N+1]; 
			while (K-- > 0) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				graph[X].add(Y);
				inDegree[Y]++;
			}
			int W = Integer.parseInt(br.readLine());
			findRes(inDegree, W);
		}
	}
	
	public static void findRes(int[] inDegree, int W) {
		long[] timeArr = new long[N+1];
		Deque<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) {
				q.add(i);
				timeArr[i] = buildTime[i];
			}
		}
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int v : graph[now]) {
				timeArr[v] = Math.max(timeArr[v], timeArr[now] + buildTime[v]);
				if (--inDegree[v] == 0) {
					q.add(v);
				}
			}
		}
		System.out.println(timeArr[W]);
	}
}