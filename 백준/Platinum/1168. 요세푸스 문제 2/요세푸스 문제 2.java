import java.io.*;
import java.util.*;

public class Main {
	static int[] segTree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
		int size = 1 << h + 1;
		segTree = new int[size];
		init(1, 0, N-1);

		int find = 0;
		int people = N;
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while (true) {
			find = (find + K - 1) % people;
			int num = query(1, 0, N-1, find + 1);
			sb.append(num + 1);
			update(1, 0, N - 1, num);
			if (--people == 0) break;
			sb.append(", ");
		}
		sb.append(">");
		System.out.print(sb);
	}
	
	public static int init(int node, int start, int end) {
		if (start == end) return segTree[node] = 1;
		int mid = (start + end) / 2;
		return segTree[node] = init(node*2, start, mid) + init(node*2+1, mid+1, end);
	}
	
	public static int update(int node, int start, int end, int del) {
		segTree[node]--;
		if (start == end) return 0;
		int mid = (start + end) / 2;
		return del <= mid ? update(node * 2, start, mid, del) : update(node * 2 + 1, mid + 1, end, del);
	}
	
	public static int query(int node, int start, int end, int order) {
		if (start == end) return start;
		int mid = (start + end) / 2;
		return order <= segTree[node * 2] ? query(node * 2, start, mid, order) : query(node * 2 + 1, mid + 1, end, order - segTree[node * 2]); 
	}
}