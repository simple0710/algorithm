import java.io.*;
import java.util.*;

public class Solution {
	static int N, res, startX, startY;
	static int[] dx = {1, 1, -1, -1}, dy = {1, -1, -1, 1};
	static int[][] board;
	static boolean[] numVisited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			res = -1;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) board[i][j] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < N ; i++) {
				for (int j = 0; j < N; j++) {
					numVisited = new boolean[101];
					startX = i;
					startY = j;
					dfs(i + dx[0], j + dy[0], 0, 1);
				}
			}
			System.out.println(String.format("#%d %d", t, res));
		}
	}
	public static void dfs(int x, int y, int d, int totalCnt) {
		if (x < 0 || x >= N || y < 0 || y >= N || numVisited[board[x][y]]) return;
		if (x == startX && y == startY) {
			res = Math.max(res, totalCnt);
			return;
		}
		numVisited[board[x][y]] = true;
		dfs(x + dx[d], y + dy[d], d, totalCnt+1);
		if (d + 1 < 4) dfs(x + dx[d+1], y + dy[d+1], d+1, totalCnt+1);
		numVisited[board[x][y]] = false;
	}
}