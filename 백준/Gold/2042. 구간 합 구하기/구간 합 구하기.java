import java.io.*;
import java.util.*;

public class Main {
	static long[] arr, tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		arr = new long[N];
		for (int i = 0; i < N; i++) arr[i] = Long.parseLong(br.readLine());
		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
		int size = 1 << (h + 1);
		tree = new long[size];
		StringBuilder sb = new StringBuilder();
		init(1, 0, N-1);
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			if (a == 1) {
				update(1, 0, N-1, b-1, c);
			} else {
				sb.append(sum(1, 0, N-1, b-1, (int) c-1) + "\n");
			}
		}
		System.out.print(sb);
	}
	public static long init(int node, int start, int end) {
		if (start == end) return tree[node] = arr[start];
		int mid = (start + end) / 2;
		return tree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end);
	}
	
	public static long sum(int node, int start, int end, int left, int right) {
		if (end < left || right < start) return 0;
		if (left <= start && end <= right) return tree[node];
		int mid = (start + end) / 2;
		return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1, mid + 1, end, left, right);
	}
	
	public static void update(int node, int start, int end, int idx, long dif) {
		if (idx < start || end < idx) return;
		if (start == end) {
			tree[node] = dif;
			arr[idx] = dif;
			return;
		}
		int mid = (start + end) / 2;
		update(node * 2, start, mid, idx, dif);
		update(node * 2 + 1, mid + 1, end, idx, dif);
		tree[node] = tree[node*2] + tree[node*2+1];
	}
}