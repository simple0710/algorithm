import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] s;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N];
		s = new int[M];
		back(0);
		System.out.print(sb);
	}
	public static void back(int depth) {
		if (depth == M) {
			for (int i = 0; i < depth; i++) {
				sb.append(s[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			s[depth] = i+1;
			back(depth+1);
			visited[i] = false;
		}
	}
}