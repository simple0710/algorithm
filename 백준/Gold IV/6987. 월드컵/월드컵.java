import java.io.*;
import java.util.*;

public class Main {
	static int[][] team, checkTeam;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 0; t < 4; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			team = new int[6][3];
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++)
					team[i][j] = Integer.parseInt(st.nextToken());
			}
			flag = false;
			checkTeam = new int[6][3];
			back(1, 0);
			System.out.print((flag ? 1 : 0) + " ");
		}
	}

	public static void back(int depth, int now) {
		if (now == 5) {
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					if (team[i][j] != checkTeam[i][j]) return;
				}
			}
			flag = true;
			return;
		}
		if (depth == 6) {
			back(now+2, now+1);
			return;
		}
		for (int i = 0; i < 3; i++) {
			if (team[now][i] > checkTeam[now][i] && team[depth][2-i] > checkTeam[depth][2-i]) {
				checkTeam[now][i]++;
				checkTeam[depth][2-i]++;
				back(depth + 1, now);
				checkTeam[now][i]--;
				checkTeam[depth][2-i]--;
			}
		}
	}

}