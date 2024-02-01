import java.io.*;

public class Main {
	static int N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		back(N, 0);
		System.out.print(sb);
	}

	public static void back(int depth, int num) {
		if (num == 1) return;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) return;
		}
		if (depth == 0) {
			sb.append(num).append("\n");
			return;
		}
		for (int i = 1; i <= 9; i++) {
			back(depth - 1, num * 10 + i);
		}
	}
}