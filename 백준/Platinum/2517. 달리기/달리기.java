import java.io.*;
import java.util.*;

public class Main {
	static int[] segTree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] sortArr = new int[N];
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = num;
			sortArr[i] = num;
		}
		
		HashMap<Integer, Integer> map = new HashMap<>(); 
		Arrays.sort(sortArr);
		for (int i = 0; i < N; i++) map.put(sortArr[i], N-i); // 해당 값에 대한 인덱스를 반환하는 map구성
		
		segTree = new int[4 * N];

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int idx = map.get(arr[i]);
			sb.append(query(1, 0, N, 0, idx-1) + 1).append("\n");
			update(1, 0, N, idx);
		}
		System.out.print(sb);
	}
	
	public static void update(int node, int start, int end, int idx) {
		if (idx < start || end < idx) return;
		segTree[node]++;
		if (start == end) return;
		int mid = (start + end) / 2;
		update(node * 2, start, mid, idx);
		update(node * 2 + 1, mid + 1, end, idx);
	}
	
	public static int query(int node, int start, int end, int left, int right) {
		if (right < start || end < left) return 0;
		if (left <= start && end <= right) return segTree[node];
		int mid = (start + end) / 2;
		return query(node * 2, start, mid, left, right) + query(node * 2 + 1, mid + 1, end, left, right);
	}
}