import java.io.*;
import java.util.*;

public class Main {
	static class Data{
		int time;
		int score;
		Data(int time, int score) {
			this.time = time;
			this.score = score;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Data> stack = new Stack<>();
		int res = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			if (command == 1) {
				int A = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				stack.add(new Data(T, A));
			}
			if (!stack.isEmpty()) {
				if (--stack.peek().time == 0) res += stack.pop().score;
			}
		}
		System.out.print(res);
	}
}