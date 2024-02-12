import java.io.*;

public class Main {
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		hanoi(N, 1, 2, 3);
		System.out.println((int) Math.pow(2, N) - 1);
		System.out.print(sb);
	}
	public static void hanoi(int cnt, int from, int tmp, int to) {
		if (cnt == 0) return;
		hanoi(cnt - 1, from, to, tmp);
		sb.append(from).append(" ").append(to).append("\n");
		hanoi(cnt - 1, tmp, from, to);
	}
}