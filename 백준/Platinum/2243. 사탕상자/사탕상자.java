import java.io.*;
import java.util.*;

public class Main {
	static final int MAX = 1_000_000;
	static int[] segTree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int h = (int) Math.ceil(Math.log(MAX) / Math.log(2));
		int size = 1 << (h + 1);
		segTree = new int[size];
		int N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			if (A == 1) {
				sb.append(query(1, 1, MAX, B)).append("\n");
			} else {
				int C = Integer.parseInt(st.nextToken());
				update(1, 1, MAX, B, C);
			}
		}
		System.out.print(sb);
	}
	private static long query(int node, int start, int end, int order) {
		segTree[node]--;
		if (start == end) return start;
		int mid = (start + end) / 2;
		return order <= segTree[node * 2] ? query(node * 2, start, mid, order) : query(node * 2 + 1, mid + 1, end, order - segTree[node * 2]);
	}
	private static void update(int node, int start, int end, int idx, int c) {
		if (idx < start || end < idx) return;
		segTree[node] += c;
		if (start == end) return;
		int mid = (start + end) / 2;
		update(node * 2, start, mid, idx, c);
		update(node * 2 + 1, mid + 1, end, idx, c);
	}
}