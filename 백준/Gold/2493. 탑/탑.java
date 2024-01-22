import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int[] res = new int[N];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			while (!stack.isEmpty()) {
				if (arr[stack.peek()] < arr[i]) stack.pop();
				else {
					res[i] = stack.peek() + 1;
					break;
				}
			}
			stack.add(i);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) sb.append(res[i]).append(" ");
		System.out.print(sb);
	}
}