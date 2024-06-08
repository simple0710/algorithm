import java.io.*;
import java.util.*;

public class Main {
	static final long INF = Long.MAX_VALUE;
	static class Point implements Comparable<Point>{
		int node;
		long distance;
		Point(int node, long distance) {
			this.node = node;
			this.distance = distance;
		}
		@Override
		public int compareTo(Point o) {
			return Long.compare(this.distance, o.distance);
		}
	}
	static int V;
	static ArrayList<Point>[] graph;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] input = br.readLine().split(" ");
    	int N = Integer.parseInt(input[0]);
    	V = Integer.parseInt(input[1]);
    	int E = Integer.parseInt(input[2]);
    	
    	input = br.readLine().split(" ");
    	int A = Integer.parseInt(input[0]);
    	int B = Integer.parseInt(input[1]);
    	
    	input = br.readLine().split(" ");
    	ArrayList<Integer> home = new ArrayList<>();
    	for (int i = 0; i < N; i++) home.add(Integer.parseInt(input[i]));
    	
    	graph = new ArrayList[V+1];
    	for (int i = 0; i <= V; i++) graph[i] = new ArrayList<>();
    	
    	for (int i = 0; i < E; i++) {
    		input = br.readLine().split(" ");
    		int a = Integer.parseInt(input[0]);
    		int b = Integer.parseInt(input[1]);
    		int l = Integer.parseInt(input[2]);
    		graph[a].add(new Point(b, l));
    		graph[b].add(new Point(a, l));
    	}
    	
    	long[] visited1 = dijkstra(A);
    	long[] visited2 = dijkstra(B);
    	
    	long res = 0;
    	for (int now: home) {
			res += visited1[now] == INF ? -1 : visited1[now];
			res += visited2[now] == INF ? -1 : visited2[now];
    	}
    	System.out.print(res);
    }
	private static long[] dijkstra(int start) {
		long[] visited = new long[V+1];
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point(start, 0));
		Arrays.fill(visited, INF);
		visited[start] = 0;
		while (!pq.isEmpty()) {
			Point now = pq.poll();
			if (visited[now.node] < now.distance) continue;
			for (Point next : graph[now.node]) {
				long nextDistance = now.distance + next.distance;
				if (visited[next.node] > nextDistance) {
					pq.add(new Point(next.node, nextDistance));
					visited[next.node] = nextDistance; 
				}
			}
		}
		return visited;
	}
}