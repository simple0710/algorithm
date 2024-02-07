import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static final int MAX = Integer.MAX_VALUE;
	static class Info {
		int node;
		int cost;
		Info(int node, int cost) {
			this.node = node;
			this.cost = cost;
		}
	}
	static ArrayList<Info>[] graph;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()) + 1;
		int M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N];
		for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new Info(b, c));
			graph[b].add(new Info(a, c));
		}
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		System.out.print(dijkstra(s, t));
	}
	public static int dijkstra(int s, int t) {
		PriorityQueue<Info> pq = new PriorityQueue<>(new Comparator<Info>() {
			@Override
			public int compare(Info o1, Info o2) {
				return o1.cost - o2.cost;
			}
		});
		int[] visited = new int[N];
		Arrays.fill(visited, MAX);
		pq.add(new Info(s, 0));
		visited[s] = 0;
		while (!pq.isEmpty()) {
			Info now = pq.poll();
			if (now.cost > visited[now.node]) continue;
			for (Info next : graph[now.node]) {
				int nextCost = now.cost + next.cost;
				if (nextCost < visited[next.node]) {
					pq.add(new Info(next.node, nextCost));
					visited[next.node] = nextCost; 
				}
			}
		}
		return visited[t];
	}
}