import java.io.*;
import java.util.*;

public class Main {
	static final int MAX = Integer.MAX_VALUE;
	static class Info {
		int start;
		int end;
		Integer cost;
		Info(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
	}
	static ArrayList<Info> answerList;
	static ArrayList<Info>[] graph;
	static int[] distance;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) graph[i] = new ArrayList<>();
		while (M-- > 0) {
			 st = new StringTokenizer(br.readLine());
			 int A = Integer.parseInt(st.nextToken());
			 int B = Integer.parseInt(st.nextToken());
			 int C = Integer.parseInt(st.nextToken());
			 graph[A].add(new Info(A, B, C));
			 graph[B].add(new Info(B, A, C));
		}
		answerList = new ArrayList<>();
		visited = new boolean[N+1];
		visited[1] = true;
		distance = new int[N+1];
		Arrays.fill(distance, MAX);
		 dijkstra();
		 System.out.println(answerList.size());
		 for (Info now : answerList) {
			 System.out.println(now.start + " " + now.end);
		 }
	}
	
	public static void dijkstra() {
		PriorityQueue<Info> pq = new PriorityQueue<>(new Comparator<Info>() {
			@Override
			public int compare(Info o1, Info o2) {
				return o1.cost.compareTo(o2.cost);
			}
		});
		pq.add(new Info(1, 1, 0));
		while (!pq.isEmpty()) {
			Info now = pq.poll();
			if (!visited[now.end]) {
				visited[now.end] = true;
				answerList.add(now);
			}
			for (Info next : graph[now.end]) {
				int nextCost = now.cost + next.cost;
				if (nextCost < distance[next.end]) {
					pq.add(new Info(next.start, next.end, nextCost));
					distance[next.end] = nextCost;
				}
			}
		}
	}
}