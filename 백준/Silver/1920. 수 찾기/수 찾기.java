import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		while (M-- > 0) sb.append(binarySearch(Integer.parseInt(st.nextToken()))).append("\n");
		System.out.print(sb);
	}

	private static int binarySearch(int now) {
		int s = 0, e = N;
		while (s < e) {
			int mid = (s + e) / 2;
			if (arr[mid] == now) return 1;
			else if (arr[mid] > now) e = mid;
			else s = mid + 1;
		}
		return 0;
	}
}