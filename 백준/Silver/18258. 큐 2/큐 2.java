import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		Queue<String> q = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String last = "-1";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if (command.equals("push")) {
				String num = st.nextToken();
				last = num;
				q.add(num);
			}
			else if (command.equals("pop")) {
				sb.append(q.isEmpty() ? -1 : q.poll()).append("\n");
			}
			else if (command.equals("size")) sb.append(q.size()).append("\n");
			else if (command.equals("empty")) sb.append(q.isEmpty() ? 1 : 0).append("\n");
			else if (command.equals("front")) sb.append(q.isEmpty() ? -1 : q.peek()).append("\n");
			else if (command.equals("back")) sb.append(q.isEmpty() ? -1 : last).append("\n");
		}
		System.out.print(sb);
	}
}