import java.io.*;

public class Main {
	static int N;
	static int[] segTree;
	static long res;
	static long[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new long[N+1];
		arr[0] = Long.MAX_VALUE;
		for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(br.readLine());

		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
		int size = 1 << h + 1;
		segTree = new int[size];
		init(1, 1, N);
		
		res = 0;
		getMax(1, N);
		System.out.print(res);
	}
	
	public static int init(int node, int start, int end) {
		if (start == end) return segTree[node] = start;
		int mid = (start + end) / 2;
		int a = init(node * 2, start, mid);
		int b = init(node * 2 + 1, mid + 1, end);
		return segTree[node] = arr[a] < arr[b] ? a : b;
	}
	
	public static int find(int node, int start, int end, int left, int right) {
		if (left > end || right < start) return 0;
		if (left <= start && end <= right) return segTree[node];
		int mid = (start + end) / 2;
		int a = find(node * 2, start, mid, left, right);
		int b = find(node * 2 + 1, mid+1, end, left, right);
		return arr[a] < arr[b] ? a : b;
	}
	
	public static void getMax(int left, int right) {
		if (left > right) return;
		int idx = find(1, 1, N, left, right);
		res = Math.max(res,  arr[idx] * (right - left + 1));
		getMax(left, idx - 1);
		getMax(idx + 1, right);
	}
}