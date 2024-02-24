import java.io.*;
import java.util.*;

public class Main {
	static class Edge implements Comparable<Edge> {
		int a, b, weight;
		Edge(int a, int b, int weight) {
			this.a = a;
			this.b = b;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] gender =	br.readLine().split(" ");
		parent = new int[N+1];
		for (int i = 1; i <= N; i++) parent[i] = i;
		ArrayList<Edge> edgeList = new ArrayList<>();
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			if (!gender[a-1].equals(gender[b-1])) edgeList.add(new Edge(a, b, weight));
		}
		Collections.sort(edgeList);
		int res = 0;
		for (Edge now : edgeList) {
			if (find(now.a) != find(now.b)) {
				union(now.a, now.b);
				res += now.weight;
			}
		}
		for (int i = 1; i <= N; i++) {
			if (find(parent[i]) != parent[1]) res = -1;
		}
		System.out.print(res);
	}
	
	public static int find(int x) {
		if (parent[x] != x) parent[x] = find(parent[x]);
		return parent[x];
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		parent[Math.max(a, b)] = Math.min(a, b);
	}
}