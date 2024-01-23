import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static class Info {
		int time;
		int score;

		Info(int time, int score) {
			this.time = time;
			this.score = score;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		int[][] dp = new int[N+1][T+1];
		Info[] datas = new Info[N + 1];
		int res = 0;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			int score = Integer.parseInt(st.nextToken());
			datas[i] = new Info(time, score);
			for (int j = 0; j <= T; j++) {
				if (datas[i].time <= j) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - datas[i].time] + datas[i].score);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		System.out.print(dp[N][T]);
	}
}