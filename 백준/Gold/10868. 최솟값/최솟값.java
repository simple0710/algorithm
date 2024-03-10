import java.io.*;
import java.util.*;

public class Main {
	static int[] arr, segTree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
		
		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
		int size = 1 << h + 1;
		segTree = new int[size];
		init(1, 0, N-1);
		
		StringBuilder sb = new StringBuilder();
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(getMin(1, 0, N-1, a-1, b-1)).append("\n");
		}
		System.out.print(sb);
	}
	
	public static int init(int node, int start, int end) {
		if (start == end) return segTree[node] = arr[start];
		int mid = (start + end) / 2;
		return segTree[node] = Math.min(init(node * 2, start, mid), init(node * 2 + 1, mid + 1, end));
	}
	
	public static int getMin(int node, int start, int end, int left, int right) {
		if (right < start || end < left) return Integer.MAX_VALUE;
		if (left <= start && end <= right) return segTree[node];
		int mid = (start + end) / 2;
		return Math.min(getMin(node * 2, start, mid, left, right), getMin(node * 2 + 1, mid + 1, end, left, right));
	}
}