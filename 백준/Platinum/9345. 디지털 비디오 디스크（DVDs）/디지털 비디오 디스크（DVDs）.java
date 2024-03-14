import java.io.*;
import java.util.*;

public class Main {
	static int[] arr, res;
	static int[][] segTree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			arr = new int[N];

			int h = (int) Math.ceil(Math.log(N) / Math.log(2));
			int size = 1 << (h + 1);
			segTree = new int[size][2];
			init(1, 0, N-1);

            while (K-- > 0) {
				st = new StringTokenizer(br.readLine());
				int Q = Integer.parseInt(st.nextToken());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				if (Q == 0) {
					int a = arr[A];
					int b = arr[B];
					update(1, 0, N-1, A, b);
					update(1, 0, N-1, B, a);
				} else {
					res = new int[] {N, 0};
					query(1, 0, N-1, A, B);
					sb.append((res[0] == A && res[1] == B) ? "YES" : "NO").append("\n");
				}
			}
		}
		System.out.print(sb);
	}
	
	public static int[] init(int node, int start, int end) {
		if (start == end) {
			arr[start] = start;
			return segTree[node] = new int[] {start, start};
		}
		int mid = (start + end) / 2;
		int[] v1 = init(node * 2, start, mid);
		int[] v2 = init(node * 2 + 1, mid + 1, end);
		return segTree[node] = new int[] {Math.min(v1[0], v2[0]), Math.max(v1[1], v2[1])};
	}
	
	public static void query(int node, int start, int end, int left, int right) {
		if (right < start || end < left) return;
		if (left <= start && end <= right) {
			res[0] = Math.min(res[0], segTree[node][0]);
			res[1] = Math.max(res[1], segTree[node][1]);
			return;
		}
		int mid = (start + end) / 2;
		query(node * 2, start, mid, left, right);
		query(node * 2 + 1, mid + 1, end, left, right);
	}
	
	public static int[] update(int node, int start, int end, int idx, int cNum) {
		if (start > idx || end < idx) return segTree[node];
		if (start == end) {
			arr[start] = cNum;
			return segTree[node] = new int[] {cNum, cNum};
		}
		int mid = (start + end) / 2;
		int[] v1 = update(node * 2, start, mid, idx, cNum);
		int[] v2 = update(node * 2 + 1, mid + 1, end, idx, cNum);
		return segTree[node] = new int[] {Math.min(v1[0], v2[0]), Math.max(v1[1], v2[1])};
	}
}