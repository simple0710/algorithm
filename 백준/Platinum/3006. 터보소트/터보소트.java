import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static long[] segTree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			map.put(arr[i], i);
		}
		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
		int size = 1 << (h + 1);
		segTree = new long[size];
		init(1, 1, N);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			int num = i / 2;
			if ((i-1) % 2 == 0) {
				num++;
				int idx = map.get(num); 
				update(1, 1, N, idx);
				sb.append(query(1, 1, N, 1, idx)).append("\n");
			} else {
				int idx = map.get(N-(num-1));
				update(1, 1, N, idx);
				sb.append(query(1, 1, N, idx, N)).append("\n");
			}
		}
		System.out.print(sb);
	}

	private static long query(int node, int start, int end, int left, int right) {
		if (start > right || left > end) return 0;
		if (left <= start && end <= right) return segTree[node];
		int mid = (start + end) / 2;
		return query(node * 2, start, mid, left, right) + query(node * 2 + 1, mid + 1, end, left, right);
	}

	private static void update(int node, int start, int end, int idx) {
		if (start > idx || end < idx) return;
		segTree[node]--;
		if (start == end) return;
		int mid = (start + end) / 2;
		update(node * 2, start, mid, idx);
		update(node * 2 + 1, mid + 1, end, idx);
	}
	
	private static long init(int node, int start, int end) {
		if (start == end) return segTree[node] = 1;
		int mid = (start + end) / 2;
		return segTree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end);
	}
}