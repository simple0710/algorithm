import java.io.*;
import java.util.*;

public class Main {
	static int[] segTree;
	static long[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new long[N+1];
		arr[0] = Long.MAX_VALUE;
		for (int i = 1; i <= N; i++) arr[i] = Long.parseLong(st.nextToken());
		
		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
		int size = 1 << (h + 1);
		segTree = new int[size];
		init(1, 1, N);
		
		int M = Integer.parseInt(br.readLine());
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int question = Integer.parseInt(st.nextToken());
			if (question == 1) {
				int idx = Integer.parseInt(st.nextToken());
				long diff = Long.parseLong(st.nextToken());
				update(1, 1, N, idx, diff);
			} else {
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());
				sb.append(query(1, 1, N, left, right)).append("\n");
			}
		}
		System.out.print(sb);
	}

	private static int init(int node, int start, int end) {
		if (start == end) return segTree[node] = start;
		int mid = (start + end) / 2;
		int left = init(node * 2, start, mid);
		int right = init(node * 2 + 1, mid + 1, end);
		return segTree[node] = arr[left] <= arr[right] ? left : right;
	}
	
	private static int update(int node, int start, int end, int idx, long diff) {
		if (start > idx || end < idx) return segTree[node];
		if (start == end) {
			arr[start] = diff;
			return segTree[node];
		}
		int mid = (start + end) / 2;
		int left = update(node * 2, start, mid, idx, diff);
		int right = update(node * 2 + 1, mid + 1, end, idx, diff);
		return segTree[node] = arr[left] <= arr[right] ? left : right;
	}
	
	private static int query(int node, int start, int end, int left, int right) {
		if (start > right || end < left) return 0;
		if (left <= start && end <= right) return segTree[node];
		int mid = (start + end) / 2;
		int leftIdx = query(node * 2, start, mid, left, right);
		int rightIdx = query(node * 2 + 1, mid + 1, end, left, right);
		return arr[leftIdx] <= arr[rightIdx] ? leftIdx : rightIdx;
	}
}