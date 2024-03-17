import java.io.*;
import java.util.*;

public class Main {
	static final int MAX = 65537;
	static int[] arr, segTree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int h = (int) Math.ceil(Math.log(MAX) / Math.log(2));
		int size = 1 << (h + 1);
		segTree = new int[size];

		arr = new int[N+1];
		long res = 0;
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			update(1, 0, MAX, arr[i], 1);
			if (i >= K) {
				res += query(1, 0, MAX, (K+1)/2);
				update(1, 0, MAX, arr[i-(K-1)], -1);
			}
		}
		System.out.print(res);
	}
	
	private static void update(int node, int start, int end, int idx, int diff) {
		if (start > idx || idx > end) return;
		segTree[node] += diff;
		if (start == end) return;
		int mid = (start + end) / 2;
		update(node * 2, start, mid, idx, diff);
		update(node * 2 + 1, mid + 1, end, idx, diff); 
	}
	
	private static int query(int node, int start, int end, long order) {
		if (start == end) return start;
		int mid = (start + end) / 2;
		return order <= segTree[node * 2] ? query(node * 2, start, mid, order) : query(node * 2 + 1, mid + 1, end, order - segTree[node * 2]);
	}
}