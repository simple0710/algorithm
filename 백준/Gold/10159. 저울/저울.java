import java.io.*;
import java.util.*;

public class Main {
	static long[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		boolean[][] graph = new boolean[N][N];
		while (M-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			graph[a][b] = true;
		}
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (graph[i][k] && graph[k][j]) graph[i][j] = true;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if (i != j && !graph[i][j] && !graph[j][i]) {
					cnt++;
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.print(sb);
	}
}