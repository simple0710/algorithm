import java.io.*;
import java.util.*;

public class Main {
	static class Data {
		int value;
		int idx;
		Data(int value, int idx) {
			this.value = value;
			this.idx = idx;
		}
	}
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Data> pq = new PriorityQueue<>(new Comparator<Data>() {
			@Override
			public int compare(Data o1, Data o2) {
				if (Integer.compare(o1.value, o2.value) == 0) return Integer.compare(o1.idx, o2.idx);
				return Integer.compare(o1.value, o2.value);
			}
		});
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			pq.add(new Data(arr[i], i));
		}
		
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			if (st.nextToken().equals("1")) {
				int idx = Integer.parseInt(st.nextToken()) - 1;
				int value = Integer.parseInt(st.nextToken());
				arr[idx] = value;
				pq.add(new Data(value, idx));
			} else {
				while (pq.peek().value != arr[pq.peek().idx]) pq.poll();
				sb.append(pq.peek().idx + 1).append("\n");
			}
		}
		System.out.print(sb);
	}
}