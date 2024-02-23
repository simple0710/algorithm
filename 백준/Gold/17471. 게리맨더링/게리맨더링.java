import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static boolean[] pickArr;
	static ArrayList<boolean[]> combiList;
	static ArrayList<Integer>[] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] people = new int[N+1];
		graph = new ArrayList[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
			graph[i] = new ArrayList<>();
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			while (st.hasMoreTokens()) {
				int next = Integer.parseInt(st.nextToken());
				graph[i].add(next);
				graph[next].add(i);
			}
		}
		int res = Integer.MAX_VALUE;
		for (int i = 1; i <= (N+1)/2; i++) {
			combiList = new ArrayList<>();
			pickArr = new boolean[N+1];
			back(i, 0, 1);
			for (boolean[] combi : combiList) {
				ArrayList<Integer> team1 = new ArrayList<>();
				ArrayList<Integer> team2 = new ArrayList<>();
				int v1 = 0;
				int v2 = 0;
				for (int j = 1; j <= N; j++) {
					if (combi[j]) {
						team1.add(j);
						v1 += people[j]; 
					}
					else {
						team2.add(j);
						v2 += people[j];
					}
				}
				if (bfs(team1) && bfs(team2)) res = Math.min(res, Math.abs(v1 - v2));
			}
		}
		System.out.print(res == Integer.MAX_VALUE ? -1 : res);
	}
	
	public static void back(int M, int depth, int start) {
		if (depth == M) {
			combiList.add(pickArr.clone());
			return;
		}
		for (int i = start; i <= N; i++) {
			pickArr[i] = true;
			back(M, depth + 1, i + 1);
			pickArr[i] = false;
		}
	}
	
	public static boolean bfs(ArrayList<Integer> team) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1];
		visited[team.get(0)] = true;
		q.add(team.get(0));
		int cnt = 1;
		while(!q.isEmpty()) {
			int now = q.poll();			
			for (int next : graph[now]) {
				if (!visited[next] && team.contains(next)) {
					cnt++;
					q.add(next);
					visited[next] = true;
				}
			}
		}
		return cnt == team.size();
	}
}