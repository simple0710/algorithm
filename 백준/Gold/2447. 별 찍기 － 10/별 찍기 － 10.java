import java.io.*;
import java.util.*;

public class Main {
	static String[][] board;
	static int[] dx = new int[] {-1, -1, -1, 0, 1, 1, 1, 0}, dy = new int[] {-1, 0, 1, 1, 1, 0, -1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		board = new String[N][N];
		recur(N/3, N/2, N/2);
		StringBuilder sb = new StringBuilder();
		for (String[] row : board) {
			for (String v : row) sb.append(v == null ? " " : "*");
			sb.append("\n");
		}
		System.out.print(sb);
	}

	public static void recur(int nowN, int nowX, int nowY) {
		if (nowN == 1) {
			for (int i = 0; i < 8; i++) board[nowX+dx[i]][nowY+dy[i]] = "*"; 
			return;
		}
		for (int i = 0; i < 8; i++) recur(nowN / 3, nowX + nowN * dx[i], nowY + nowN * dy[i]);
	}
}