import java.io.*;
import java.util.*;

public class Main {
	static int[] arr, segTree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
		int size = 1 << (h + 1);
		segTree = new int[size];
		init(1, 1, N);
		int M = Integer.parseInt(br.readLine());
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a == 1) {
				update(1, 1, N, b, c);
			} else {
				sb.append(query(1, 1, N, b, c)).append("\n");
			}
		}
		System.out.print(sb);
	}

	private static int query(int node, int start, int end, int left, int right) {
		if (right < start || end < left) return Integer.MAX_VALUE;
		if (left <= start && end <= right) return segTree[node];
		int mid = (start + end) / 2;
		return Math.min(query(node * 2, start, mid, left, right), query(node * 2 + 1, mid + 1, end, left, right));
	}
	
	private static int update(int node, int start, int end, int idx, int value) {
		if (idx < start || end < idx) return segTree[node];
		if (start == end) return segTree[node] = value;
		int mid = (start + end) / 2;
		return segTree[node] = Math.min(update(node * 2, start, mid, idx, value), update(node * 2 + 1, mid + 1, end, idx, value));
	}
	
	private static int init(int node, int start, int end) {
		if (start == end) return segTree[node] = arr[start];
		int mid = (start + end) / 2;
		return segTree[node] = Math.min(init(node * 2, start, mid), init(node * 2 + 1, mid + 1, end));
	}
}