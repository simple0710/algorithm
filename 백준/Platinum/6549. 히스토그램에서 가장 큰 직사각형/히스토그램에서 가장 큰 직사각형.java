import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			if (N == 0) break;
			long[] numsArr = new long[N+1];
			for (int i = 0; i < N; i++) numsArr[i] = Long.parseLong(st.nextToken());
			sb.append(findMax(numsArr)).append("\n");
		}
		System.out.print(sb);
	}

	public static long findMax(long[] arr) {
		long maxArea = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
				long height = arr[stack.pop()];
				long width = stack.isEmpty() ? i : i - 1 - stack.peek();
				maxArea = Math.max(maxArea, width * height);
			}
			stack.add(i);
		}
		return maxArea;
	}
}