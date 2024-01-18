import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[][] room = new int[2][7];
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			room[s][grade]++;
		}
		int res = 0;
		for (int[] row : room) {
			for (int i = 1; i < 7; i++) {
				res += Math.ceil((double) row[i] / K);
			}
		}
		System.out.println(res);
	}
}