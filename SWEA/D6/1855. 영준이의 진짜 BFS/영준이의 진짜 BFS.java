import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[] parent, parentCenter, visited;
	static ArrayList<Integer> numList;
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			graph = new ArrayList[N+1];
			parent = new int[N+1];
			parentCenter = new int[N+1];
			visited = new int[N+1];
			for (int i = 1; i < N + 1; i++) {
				graph[i] = new ArrayList<>();
			}
			long res = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			if (N != 1) {
				res = 1;
				for (int i = 2; i < N + 1; i++) {
					int p = Integer.parseInt(st.nextToken());
					graph[p].add(i);
					parent[i] = p;
				}
				numList = new ArrayList<>();
				findNumsTurn();
				for (int i = 1; i < N-1; i++) {
					res += findSameParent(numList.get(i-1), numList.get(i));
				}
			}
			System.out.println(String.format("#%d %s", t, String.valueOf(res)));
		}
	}
	
	public static void findNumsTurn() {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.add(1);
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int next : graph[now]) {
				numList.add(next);
				q.add(next);
				if (graph[now].size() > 1) parentCenter[next] = now;
				else parentCenter[next] = parentCenter[now];
				visited[next] = visited[now] + 1;
			}
		}
	}
	
	public static int find(int x) {
		return parentCenter[x];
	}
	
	public static int findSameParent(int beforeNum, int nowNum) {
		int cnt = 0;
		if (beforeNum == parent[nowNum]) return 1;
		while (beforeNum != nowNum) {
			if (visited[beforeNum] >= visited[nowNum]) {
				cnt += visited[beforeNum] - visited[find(beforeNum)];
				beforeNum = find(beforeNum);
			}
			else {
				cnt += visited[nowNum] - visited[find(nowNum)];
				nowNum = find(nowNum);
			}
		}
		return cnt;
	}
}