import java.io.*;
import java.util.*;

public class Main {
	static final long MOD = 1_000_000_007;
	static long[] arr, segTree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		arr = new long[N+1];
		for (int i = 1; i <= N; i++) arr[i] = Long.parseLong(br.readLine());
		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
		int size = 1 << h + 1;
		segTree = new long[size];
		init(1, 1, N);
		StringBuilder sb = new StringBuilder();
		M += K;
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Integer.parseInt(st.nextToken());
			if (a == 1) update(1, 1, N, b, c);
			else sb.append(multiply(1, 1, N, b, (int) c)).append("\n");
		}
		System.out.print(sb);
	}
	static long init(int node, int start, int end) {
		if (start == end) return segTree[node] = arr[start];
		int mid = (start + end) / 2;
		return segTree[node] = init(node * 2, start, mid) * init(node * 2 + 1, mid + 1, end) % MOD; 
	}
	
	static long update(int node, int start, int end, int idx, long val) {
		if (idx < start || end < idx) return segTree[node];
		if (start == end) {
			arr[idx] = val;
			return segTree[node] = val;
		}
		int mid = (start + end) / 2;
		return segTree[node] = update(node*2, start, mid, idx, val) * update(node*2+1, mid+1, end, idx, val) % MOD;
	}
	
	static long multiply(int node, int start, int end, int left, int right) {
		if (end < left || right < start) return 1;
		if (left <= start && end <= right) return segTree[node];
		int mid = (start + end) / 2;
		return multiply(node*2, start, mid, left, right) * multiply(node*2+1, mid+1, end, left, right) % MOD;
	}
}