import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		bfs(N, K);
	}

	public static void bfs(int N, int K) {
		Deque<Integer> q = new LinkedList<>();
		q.add(N);
		int[] visited = new int[100001];
		visited[N] = 1;
		while (!q.isEmpty()) {
			int v = q.poll();
			if (v == K) {
				System.out.println(visited[v] - 1);
				break;
			}
			for (int nv : new int[] { 2 * v, v + 1, v - 1 }) {
				if (0 <= nv && nv < 100001 && visited[nv] == 0) {
					q.add(nv);
					visited[nv] = visited[v] + 1;
				}
			}
		}
	}
}