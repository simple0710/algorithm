import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		LinkedList<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++)
			q.add(i);
		int res = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int now = Integer.parseInt(st.nextToken());
			int idx = q.indexOf(now);
			if (idx <= q.size() / 2) {
				while (q.peekFirst() != now) {
					q.add(q.poll());
					res++;
				}
			} else {
				while (q.peekFirst() != now) {
					q.addFirst(q.pollLast());
					res++;
				}
			}
			q.pop();
		}
		System.out.print(res);
	}
}