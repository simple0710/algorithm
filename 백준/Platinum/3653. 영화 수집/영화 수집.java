import java.io.*;
import java.util.*;

public class Main {
	static int[] segTree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] arr = new int[N+1];
			int max = N+M;
			
			int h = (int) Math.ceil(Math.log(max) / Math.log(2));
			int size = 1 << (h + 1);
			segTree = new int[size];
			
			for (int i = 1; i <= N; i++) {
				arr[i] = N-i+1;
				update(1, 1, max, i, 1);
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++) {
				int now = Integer.parseInt(st.nextToken());
				sb.append(query(1, 1, max, arr[now]+1, N+i-1)).append(" ");
				update(1, 1, max, arr[now], -1);
				update(1, 1, max, N+i, 1);
				arr[now] = N + i;
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	public static int init(int node, int start, int end) {
		if (start == end) return segTree[node] = 1;
		int mid = (start + end) / 2;
		return segTree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end);
	}
	
	public static int query(int node, int start, int end, int left, int right) {
		if (end < left || right < start) return 0;
		if (left <= start && end <= right) return segTree[node];
		int mid = (start + end) / 2;
		return query(node * 2, start, mid, left, right) + query(node * 2 + 1, mid + 1, end, left, right);
	}
	
	public static void update(int node, int start, int end, int idx, int val) {
		if (idx < start || end < idx) return;
		segTree[node] += val;
		if (start == end) return;
		
		int mid = (start + end) / 2;
		update(node * 2, start, mid, idx, val);
		update(node * 2 + 1, mid + 1, end, idx, val);
	}
}