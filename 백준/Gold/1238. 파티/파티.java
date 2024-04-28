import java.io.*;
import java.util.*;

public class Main {
	static final int MAX = Integer.MAX_VALUE;
	static class Data implements Comparable<Data> {
		int node;
		int cost;
		Data(int node, int cost) {
			this.node = node;
			this.cost = cost;
		}
		@Override
		public int compareTo(Data o) {
			return this.cost - o.cost;
		}
	}
	static int N, X;
	static ArrayList<Data>[] graph, rGraph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str;
		str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		X = Integer.parseInt(str[2]);
		graph = new ArrayList[N+1];
		rGraph = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
			rGraph[i] = new ArrayList<>();
		}
		while (M-- > 0) {
			str = br.readLine().split(" ");
			int A = Integer.parseInt(str[0]);
			int B = Integer.parseInt(str[1]);
			int T = Integer.parseInt(str[2]);
			graph[A].add(new Data(B, T));
			rGraph[B].add(new Data(A, T));
		}
		int[] dist1 = getDijkstra(graph);
		int[] dist2 = getDijkstra(rGraph);
		int res = 0;
		for (int i = 1; i <= N; i++) res = Math.max(res, dist1[i] + dist2[i]);
		System.out.print(res);
	}
	
	private static int[] getDijkstra(ArrayList<Data>[] graph) {
		PriorityQueue<Data> pq = new PriorityQueue<>();
		int[] dist = new int[N+1];
		Arrays.fill(dist, MAX);
		dist[X] = 0;
		pq.add(new Data(X, 0));
		while (!pq.isEmpty()) {
			Data now = pq.poll();
			if (dist[now.node] < now.cost) continue;
			for (Data next : graph[now.node]) {
				int nextCost = now.cost + next.cost;
				if (dist[next.node] > nextCost) {
					pq.add(new Data(next.node, nextCost));
					dist[next.node] = nextCost;
				}
			}
		}
		return dist;
	}
}