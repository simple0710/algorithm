import java.io.*;
import java.util.*;

public class Main {
	static int[][] moves1 = {{0, -1}, {-1, -1}, {-1, 0}};
	static int[][] moves2 = {{-1, 0}, {-1, 1}, {0, 1}};
	static int[][] moves3 = {{0, 1}, {1, 1}, {1, 0}};
	static int[][] moves4 = {{1, 0}, {1, -1}, {0, -1}};
	static int N, M, res;
	static boolean[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new boolean[N][M];
		res = 1;
		back(0, 0);
		System.out.print(res);
	}
	
	public static void back(int depth, int start) {
		if (depth == N * M) return;
		for (int i = start; i < N * M; i++) {
			int x = i / M;
			int y = i % M;
			if (check(x, y)) {
				res++;
				board[x][y] = true;
				back(depth + 1, i + 1);
				board[x][y] = false;
			}
		}
	}
	
	public static boolean check(int x, int y) {
		for (int[][] moveType : new int[][][]{moves1, moves2, moves3, moves4}) {
			int cnt = 0;
			for (int[] move : moveType) {
				int nx = x + move[0];
				int ny = y + move[1];
				if (0 <= nx && nx < N && 0 <= ny && ny < M && board[nx][ny]) {
					cnt++;
				}
			}
			if (cnt == 3) return false;
		}
		return true;
	}
}