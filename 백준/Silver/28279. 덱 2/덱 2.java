import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main
{
	public static void main(String args[]) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringBuilder sb = new StringBuilder();
		 int N = Integer.parseInt(br.readLine());
		 Deque<Integer> q = new LinkedList<>();
		 for (int i = 0; i < N; i++) {
			 StringTokenizer st = new StringTokenizer(br.readLine());
			 int command = Integer.parseInt(st.nextToken());
			 if (command == 1) q.addFirst(Integer.parseInt(st.nextToken()));
			 else if (command == 2) q.add(Integer.parseInt(st.nextToken()));
			 else if (command == 3) {
				 if (q.isEmpty()) sb.append(-1);
				 else sb.append(q.poll());
			 }
			 else if (command == 4) {
				 if (q.isEmpty()) sb.append(-1);
				 else sb.append(q.pollLast());
			 }
			 else if (command == 5) sb.append(q.size());
			 else if (command == 6) {
				 if (q.isEmpty()) sb.append(1);
				 else sb.append(0);
			 }
			 else if (command == 7) {
				 if (q.isEmpty()) sb.append(-1);
				 else sb.append(q.peekFirst());
			 }
			 else {
				 if (q.isEmpty()) sb.append(-1);
				 else sb.append(q.peekLast());
			 }
			 if (command > 2) sb.append("\n");
		 }
		 System.out.println(sb);
	}
}