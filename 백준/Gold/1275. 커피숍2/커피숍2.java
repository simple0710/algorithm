import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static long[] segTree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
		int size = 1 << (h + 1);
		segTree = new long[size];
		init(1, 1, N);
		
		while (Q-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (x > y) {
				int tmp = x;
				x = y;
				y = tmp;
			}
			sb.append(query(1, 1, N, x, y)).append("\n");
			update(1, 1, N, a, b);
		}
		System.out.print(sb);
	}
	
	public static long init(int node, int start, int end) {
		if (start == end) return segTree[node] = arr[start];
		int mid = (start + end) / 2;
		return segTree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end);
	}
	
	public static long query(int node, int start, int end, int left, int right) {
		if (right < start || end < left) return 0;
		if (left <= start && end <= right) return segTree[node];
		int mid = (start + end) / 2;
		return query(node * 2, start, mid, left, right) + query(node * 2 + 1, mid + 1, end, left, right);
	}
	
	public static long update(int node, int start, int end, int idx, int cNum) {
		if (idx < start || end < idx) return segTree[node];
		if (start == end) return segTree[node] = cNum;
		int mid = (start + end) / 2;
		return segTree[node] = update(node * 2, start, mid, idx, cNum) + update(node * 2 + 1, mid + 1, end, idx, cNum);
	}
}