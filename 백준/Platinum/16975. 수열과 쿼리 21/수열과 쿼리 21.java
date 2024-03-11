import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static long output;
	static long[] segTree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
		int size = 1 << h + 1;
		segTree = new long[size];
		init(1, 0, N-1);
		
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if (a == 1) {
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				long k = Long.parseLong(st.nextToken());
				addNum(1, 0, N-1, i-1, j-1, k);
			} else {
				int x = Integer.parseInt(st.nextToken());
				findNum(1, 0, N-1, x-1, 0);
				sb.append(output).append("\n");
			}
		}
		System.out.print(sb);
	}
	
	public static void init(int node, int start, int end) {
		if (start == end) {
			segTree[node] = arr[start];
			return;
		}
		int mid = (start + end) / 2;
		init(node * 2, start, mid);
		init(node * 2 + 1, mid + 1, end);
	}
	
	public static void addNum(int node, int start, int end, int left, int right, long k) {
		if (right < start || end < left) return;
		if (left <= start && end <= right) {
			segTree[node] += k;
			return;
		}
		int mid = (start + end) / 2;
		addNum(node * 2, start, mid, left, right, k);
		addNum(node * 2 + 1, mid+1, end, left, right, k);
	}
	
	public static void findNum(int node, int start, int end, int idx, long add) {
		if (idx < start || end < idx) return;
		if (start == end) {
			output = segTree[node] + add;
			return;
		}
		int mid = (start + end) / 2;
		findNum(node * 2, start, mid, idx, add + segTree[node]);
		findNum(node * 2 + 1, mid + 1, end, idx, add + segTree[node]);
	}
}