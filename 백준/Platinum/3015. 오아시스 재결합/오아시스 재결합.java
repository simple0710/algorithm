import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static class Data {
		long height;
		int cnt;
		Data(long height, int cnt) {
			this.height =  height;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Data> stack = new Stack<>();
		long res = 0;
		for (int i = 0; i < N; i++) {
			long now = Long.parseLong(br.readLine());
			while (!stack.isEmpty()) {
				Data info = stack.pop();
				if (info.height > now) {
					res++;
					stack.add(info);
					stack.add(new Data(now, 1));
					break;
				} else if (info.height == now) {
					res += info.cnt + (stack.isEmpty() ? 0 : 1);
					stack.add(new Data(now, info.cnt+1));
					break;
				}
				res += info.cnt;
			}
			if (stack.isEmpty()) stack.add(new Data(now, 1));
		}
		System.out.print(res);
	}
}