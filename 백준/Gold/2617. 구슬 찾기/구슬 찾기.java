import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] graph = new boolean[N + 1][N + 1];
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = true;
		}
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (!graph[i][k]) break;
					if (i!=j && graph[k][j])
					graph[i][j] = true;
				}
			}
		}
		int res = 0;
		for (int i = 1; i <= N; i++) {
			int cnt1 = 0;
			int cnt2 = 0;
			for (int j = 1; j <= N; j++) {
				if (i != j) {
					if (graph[i][j]) cnt1++;
					else if (graph[j][i]) cnt2++;
				}
			}
			if (Math.max(cnt1, cnt2) >= (N+1) / 2) res++;
		}
		System.out.print(res);
	}
}