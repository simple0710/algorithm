import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = N-1; j >= 0; j--) {
				sb.append(j > i ? " " : "*");
			}
			sb.append("\n");
		}
		for (int i = 0; i < N-1; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(j <= i ? " " : "*");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}