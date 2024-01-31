import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		Deque<Integer> q = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		int[] numsArr = new int[N];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());
			numsArr[i] = now;
			while (!q.isEmpty() && numsArr[q.peekLast()] > now) q.pollLast();
			q.add(i);
			if (q.peekFirst() < i-L+1) q.poll();
			sb.append(numsArr[q.peekFirst()]).append(" ");
		}
		System.out.print(sb);
	}
}