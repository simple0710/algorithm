import java.io.*;
import java.util.*;

public class Main {
	static long[] segTree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] arr1 = br.readLine().split(" ");
		String[] arr2 = br.readLine().split(" ");
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) map.put(arr2[i], i);
		
		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
		int size = 1 << (h + 1);
		segTree = new long[size];

		long res = 0;
		for (int i = 0; i < N; i++) {
			int idx = map.get(arr1[i]);
			res += check(1, 0, N-1, idx+1, N-1);
			
			update(1, 0, N-1, idx, 1);
		}
		System.out.print(res);
	}
	
	public static long check(int node, int start, int end, int left, int right) {
		if (right < start || left > end) return 0;
		if (left <= start && end <= right) return segTree[node];
		int mid = (start + end) / 2;
		return check(node * 2, start, mid, left, right) + check(node * 2 + 1, mid + 1, end, left, right);
	}
	
	public static long update(int node, int start, int end, int idx, long diff) {
		if (idx < start || idx > end) return segTree[node];
		if (start == end) return segTree[node] += diff;
		int mid = (start + end) / 2;
		return segTree[node] = update(node * 2, start, mid, idx, diff) + update(node * 2 + 1, mid + 1, end, idx, diff);
	}
}