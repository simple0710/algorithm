import java.io.*;
import java.util.*;

public class Main {
	static int[] arr, segTree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
		int size = 1 << (h + 1);
		segTree = new int[size];
		init(1, 1, N);

        int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a == 1) {
				int c = Integer.parseInt(st.nextToken());
				update(1, 1, N, b, c);
			} else {
				sb.append(query(1, 1, N, b)).append("\n");
			}
		}
		System.out.print(sb);
	}

	private static int init(int node, int start, int end) {
		if (start == end) return segTree[node] = arr[start];
		int mid = (start + end) / 2;
		return segTree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end);  
	}

	private static int query(int node, int start, int end, int order) {
		if (start == end) return start;
		int mid = (start + end) / 2;
		return order <= segTree[node * 2] ? query(node * 2, start, mid, order) : query(node * 2 + 1, mid + 1, end, order - segTree[node * 2]);
	}

	private static int update(int node, int start, int end, int idx, int val) {
		if (start > idx || end < idx) return segTree[node];
		segTree[node] += val;
		if (start == end) return segTree[node];
		int mid = (start + end) / 2;
		return segTree[node] = update(node * 2, start, mid, idx, val) + update(node * 2 + 1, mid + 1, end, idx, val); 
	}
}