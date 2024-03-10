import java.io.*;
import java.util.*;

public class Main {
	static class Info implements Comparable<Info> {
		int idx, val;
		Info (int idx, int val) {
			this.idx = idx;
			this.val = val;
		}
		
		@Override
		public int compareTo(Info o) {
			return this.val - o.val;
		}
	}
	static long[] segTree;
	static Info[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new Info[N];
		for (int i = 0; i < N; i++) {
			arr[i] = new Info(i, Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(arr);
		
		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
		int size = 1 << (h + 1);
		segTree = new long[size];

		long res = 0;
		int prev = Integer.MAX_VALUE;
		ArrayList<Integer> sameNumIdx = new ArrayList<>();
		for (Info now : arr) {
			if (prev != now.val) {
				for (int idx : sameNumIdx) {
					 update(1, 0, N-1, idx);
				}
				sameNumIdx.clear();
				prev = now.val;
			}
			res += getSwapCnt(1, 0, N-1, now.idx+1, N-1);
			sameNumIdx.add(now.idx);
		}
		System.out.print(res);
	}
	
	public static long getSwapCnt(int node, int start, int end, int left, int right) {
		if (right < start || end < left) return 0;
		if (left <= start && end <= right) return segTree[node];
		int mid = (start + end) / 2;
		return getSwapCnt(node * 2, start, mid, left, right) + getSwapCnt(node * 2 + 1, mid + 1, end, left, right);
	}
	
	public static void update(int node, int start, int end, int idx) {
		if (idx < start || end < idx) return;
		if (start == end) {
			segTree[node] = 1L;
			return;
		}
		int mid = (start + end) / 2;
		update(node * 2, start, mid, idx);
		update(node * 2 + 1, mid + 1, end, idx);
		segTree[node] = segTree[node*2] + segTree[node*2+1];
	}
}