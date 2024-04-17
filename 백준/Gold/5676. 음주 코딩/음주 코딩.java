import java.io.*;

public class Main {
	static int[] arr, segTree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		while ((str = br.readLine()) != null) {
			StringBuilder sb = new StringBuilder();
			String[] st = str.split(" ");
			int N = Integer.parseInt(st[0]);
			int K = Integer.parseInt(st[1]);
			arr = new int[N+1];
			st = br.readLine().split(" ");
			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(st[i-1]);
				if (arr[i] > 0) arr[i] = 1;
				else if (arr[i] < 0) arr[i] = -1; 
			}
			int h = (int) Math.ceil(Math.log(N) / Math.log(2));
			int size = 1 << (h + 1);
			segTree = new int[size];
			init(1, 1, N);
			while (K-- > 0) {
				st = br.readLine().split(" ");
				String c = st[0];
				int i = Integer.parseInt(st[1]);
				int j = Integer.parseInt(st[2]);
				if (c.equals("P")) {
					int result = query(1, 1, N, i, j);
					String output = "0";
					if (result > 0) output = "+";
					else if (result < 0) output = "-";
					sb.append(output);
				}
				else {
					if (j > 0) j = 1;
					else if (j < 0) j = -1;
					update(1, 1, N, i, j);
				}
			}
			System.out.println(sb);
		}
	}
	
	private static int update(int node, int start, int end, int idx, int val) {
		if (start > idx || idx > end) return segTree[node];
		if (start == end) return segTree[node] = val;
		int mid = (start + end) / 2;
		return segTree[node] = update(node * 2, start, mid, idx, val) * update(node * 2 + 1, mid + 1, end, idx, val);
	}
	
	private static int query(int node, int start, int end, int left, int right) {
		if (right < start || end < left) return 1;
		if (left <= start && end <= right) return segTree[node];
		int mid = (start + end) / 2;
		return query(node * 2, start, mid, left, right) * query(node * 2 + 1, mid + 1, end, left, right);
	}
	
	private static int init(int node, int start, int end) {
		if (start==end) return segTree[node] = arr[start];
		int mid = (start + end) / 2;
		return segTree[node] = init(node * 2, start, mid) * init(node * 2 + 1, mid + 1, end);
	}
}