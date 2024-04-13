import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		N = Integer.parseInt(st[0]);
		M = Integer.parseInt(st[1]);
		arr = new int[N];
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		System.out.print(twoPointer());
	}
	private static int twoPointer() {
		int s = 0;
		int res = 2_000_000_000;
		for (int e = 0; e < N; e++) {
			while (s < N && arr[e] - arr[s] >= M) {
				res = Math.min(res, arr[e] - arr[s]);
				s++;
			}
		}
		return res;
	}
}