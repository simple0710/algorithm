import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] check = new boolean[N+1][N+1];
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			check[a][b] = true;
		}
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (check[i][k] && check[k][j]) check[i][j] = true;
				}
			}
		}
		int res = 0;
		for (int i = 1; i <= N ; i++) {
			int cnt = 1;
			for (int j = 1; j <= N; j++) {
				if (i!=j && !check[i][j] && !check[j][i]) {
					cnt = 0;
					break;
				}
			}
			res += cnt; 
		}
		System.out.print(res);
	}
}