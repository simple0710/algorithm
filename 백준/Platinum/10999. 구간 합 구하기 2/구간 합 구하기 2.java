import java.io.*;
import java.util.*;

public class Main {
	static long[] arr, segTree, lazy;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		M += K;
		
		arr = new long[N];
		for (int i = 0; i < N; i++) arr[i] = Long.parseLong(br.readLine());

		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
		int size = 1 << (h + 1);
		lazy = new long[size];
		segTree = new long[size];
		init(1, 0, N-1);
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			if (a == 1) {
				long diff = Long.parseLong(st.nextToken());
				updateRange(1, 0, N-1, left-1, right-1, diff);
			} else sb.append(query(1, 0, N-1, left-1, right-1)).append("\n");
		}
		System.out.print(sb);
	}
	
	public static long init(int node, int start, int end) {
		if (start == end) return segTree[node] = arr[start];
		int mid = (start + end) / 2;
		return segTree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end);
	}
	
	public static void updateRange(int node, int start, int end, int left, int right, long diff) {
		updateLazy(node, start, end);
		if (left > end || right < start) return;
		if (left <= start && end <= right) {
			segTree[node] += (end-start+1)*diff;
			if (start != end) {
				lazy[node*2] += diff;
				lazy[node*2+1] += diff;
			}
			return;
		}
		int mid = (start + end) / 2;
		updateRange(node * 2, start, mid, left, right, diff);
		updateRange(node * 2 + 1, mid + 1, end, left, right, diff);
		segTree[node] = segTree[node * 2] + segTree[node * 2 + 1];
	}
	
	public static void updateLazy(int node, int start, int end) {
		if (lazy[node] != 0) {
			segTree[node] += (end-start+1)*lazy[node];
			if (start != end) {
				lazy[node*2] += lazy[node];
				lazy[node*2+1] += lazy[node];
			}
			lazy[node] = 0;
		}
	}
	
	public static long query(int node, int start, int end, int left, int right) {
		updateLazy(node, start, end);
		if (left > end || right < start) return 0;
		if (left <= start && end <= right) return segTree[node];
		int mid = (start + end) / 2;
		return query(node * 2, start, mid, left, right) + query(node * 2 + 1, mid + 1, end, left, right);
	}
}