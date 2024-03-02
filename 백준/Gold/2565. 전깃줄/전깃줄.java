import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<int[]> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.add(new int[] {a, b});
		}
		Collections.sort(list, (o1, o2) -> Integer.compare(o1[0], o2[0]));
		int[] dp = new int[N];
		int connect = 0;
		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				int[] a = list.get(i);
				int[] b = list.get(j);
				if (a[1] > b[1]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					connect = Math.max(connect, dp[i]);
				}
			}
		}
		System.out.print(N-connect);
	}
}