import java.io.*;
import java.util.*;

public class Main {
	static final int MAX = Integer.MAX_VALUE;
	static class Info {
		int node;
		Integer totalCost;
		Integer nowCost;
		Info(int node, int totalCost) {
			this.node = node;
			this.totalCost = totalCost;
		}
		Info(int node, int totalCost, int nowCost) {
			this.node = node;
			this.totalCost = totalCost;
			this.nowCost = nowCost;
		}
		
	}
	static int N, M;
	static int[] defaultDistance;
	static ArrayList<Info>[] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) graph[i] = new ArrayList<>();
		while (M-- > 0) {
			 st = new StringTokenizer(br.readLine());
			 int A = Integer.parseInt(st.nextToken());
			 int B = Integer.parseInt(st.nextToken());
			 int C = Integer.parseInt(st.nextToken());
			 graph[A].add(new Info(B, C));
			 graph[B].add(new Info(A, C));
		}
		defaultDistance = new int[N+1];
		Arrays.fill(defaultDistance, MAX);
		defaultDijkstra();
		System.out.print(accessDijkstra());
	}
	
	public static void defaultDijkstra() {
		PriorityQueue<Info> pq = new PriorityQueue<>(new Comparator<Info>() {
			@Override
			public int compare(Info o1, Info o2) {
				return o1.totalCost.compareTo(o2.totalCost);
			}
		});
		pq.add(new Info(1, 0));
		while (!pq.isEmpty()) {
			Info now = pq.poll();
			for (Info next : graph[now.node]) {
				int nextCost = now.totalCost + next.totalCost;
				if (nextCost < defaultDistance[next.node]) {
					pq.add(new Info(next.node, nextCost));
					defaultDistance[next.node] = nextCost;
				}
			}
		}
	}
	
	public static StringBuilder accessDijkstra() {
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Info> pq = new PriorityQueue<>(new Comparator<Info>() {
			@Override
			public int compare(Info o1, Info o2) {
				if (o1.nowCost == o2.nowCost) return o1.totalCost.compareTo(o2.totalCost);
				return o1.nowCost.compareTo(o2.nowCost);
			}
		});
		int cnt = 0;
		int[] accessCheck = new int[N+1];
		accessCheck[1] = 1;
		pq.add(new Info(1, 0, 0));
		while(!pq.isEmpty()) {
			Info now = pq.poll();
			for (Info next : graph[now.node]) {
				int nextCost = now.totalCost + next.totalCost;
				if (nextCost <= defaultDistance[next.node] && accessCheck[next.node] == 0) {
					cnt++;
					sb.append(now.node).append(" ").append(next.node).append("\n");
					accessCheck[next.node] = now.node;
					pq.add(new Info(next.node, nextCost, next.totalCost));
				}
			}
		}
		System.out.println(cnt);
		return sb;
	}
}