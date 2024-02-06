import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] resArr, dx = new int[]{0, 0, 0, 1, 1, 1, 2, 2, 2}, dy = new int[]{0, 1, 2, 0, 1, 2, 0, 1, 2};
	static int[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		resArr = new int[3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken()) + 1;
			}
		}
		recur(N, 0, 0);
		for (int v : resArr) System.out.println(v);
	}
	
	public static void recur(int nowN, int startX, int startY) {
		if (isPaperSame(nowN, startX, startY)) {
			resArr[board[startX][startY]]++;
			return;
		}
		int nextN = nowN / 3;
		for (int i = 0; i < 9; i++) {
			recur(nextN, startX + dx[i] * nextN, startY + dy[i] * nextN);
		}
	}
	
	public static boolean isPaperSame(int size, int startX, int startY) {
		int v = board[startX][startY];
		for (int i = startX; i < startX + size; i++) {
			for (int j = startY; j < startY + size; j++) {
				if (v != board[i][j]) return false;
			}
		}
		return true;
	}
}