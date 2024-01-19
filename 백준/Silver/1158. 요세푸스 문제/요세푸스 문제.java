import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Deque<Integer> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for (int i = 1; i <= N; i++) q.add(i);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < K-1; j++) {
				q.add(q.poll());
			}
			sb.append(q.poll());
			if (i < N-1) sb.append(",").append(" ");
			else sb.append(">");
		}
		System.out.print(sb);
	}
}