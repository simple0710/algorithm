import java.io.*;

public class Main {
	static final int MAX = 200_000;
	static final int MOD = 1_000_000_007;
	static long[] segTree, cntSegTree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int h = (int) Math.ceil(Math.log(MAX) / Math.log(2));
		int size = 1 << (h+1);
		segTree = new long[size];
		cntSegTree = new long[size];
		long res = 1;
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(br.readLine()); 
			long distance1 = now * query(cntSegTree, 1, 0, MAX, 0, now-1) - query(segTree, 1, 0, MAX, 0, now-1) % MOD;
			long distance2 = query(segTree, 1, 0, MAX, now+1, MAX) - now * query(cntSegTree, 1, 0, MAX, now+1, MAX) % MOD;
			if (i != 0) res = res % MOD * (distance1 % MOD + distance2 % MOD);
			update(1, 0, MAX, now);
		}
		System.out.print(res % MOD);
	}

	private static long query(long[] tree, int node, int start, int end, int left, long right) {
		if (start > right || end < left) return 0;
		if (left <= start && end <= right) return tree[node];
		int mid = (start + end) / 2;
		return query(tree, node * 2, start, mid, left, right) + query(tree, node * 2 + 1, mid + 1, end, left, right);
	}

	private static void update(int node, int start, int end, long now) {
		if (start > now || end < now) return;
		segTree[node] += now;
		cntSegTree[node]++;
		if (start == end) return;
		int mid = (start + end) / 2;
		update(node * 2, start, mid, now);
		update(node * 2 + 1, mid+1, end, now);
	}
}