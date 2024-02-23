import java.io.*;
import java.util.*;

public class Main {
	static int N, res;
	static int[] pick, playGround;
	static int[][] scoreBoard;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		scoreBoard = new int[N][9];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				scoreBoard[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		playGround = new int[8];
		pick = new int[9];
		visited = new boolean[9];
		pick[3] = 0;
		visited[0] = true;
		back(0);
		System.out.print(res);
	}
	
	public static void back(int depth) {
		if (depth == 9) {
			res = Math.max(res, play());
			return;
		}
		if (depth != 3) {
			for (int i = 0; i < 9; i++) {
				if (!visited[i]) {
					visited[i] = true;
					pick[depth] = i;
					back(depth+1);
					visited[i] = false;
				}
			}
		}
		else back(depth+1);
	}
	
	public static int play() {
		int totalScore = 0;
		int playCnt = 0;
		int out = 0;
		int now = 0;
		while (playCnt < N) {
			int nowRes = scoreBoard[playCnt][pick[now++]];
			if (nowRes != 0) run(nowRes);
			else out++;
			now%=9;
			if (out == 3) {
				out = 0;
				playCnt++;
				for (int i = 1; i < 8; i++) {
					if (4 <= i) totalScore += playGround[i];
					playGround[i] = 0;
				}
				
			}
		}
		return totalScore;
	}
	
	public static void run(int num) {
		for (int i = 3; i > 0; i--) {
			if (0 < playGround[i]) {
				playGround[i] = 0;
				playGround[i+num] += 1;
			}
		}
		playGround[num] += 1;
	}
}