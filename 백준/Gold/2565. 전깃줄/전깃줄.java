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
		Collections.sort(list, (o1, o2) -> Integer.compare(o1[1], o2[1]));
		int[] dp = new int[N];
		int connect = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N; j++) {
				int[] a = list.get(i);
				int[] b = list.get(j);
				if ((a[0] < b[0] && a[1] < b[1]) || (a[0] > b[0] && a[1] > b[1])) {
					dp[j] = Math.max(dp[i] + 1, dp[j]);
					connect = Math.max(connect, dp[j]);
				}	
			}
		}
		System.out.println(N-connect);
	}
}