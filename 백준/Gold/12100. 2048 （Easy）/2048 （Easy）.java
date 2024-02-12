import java.io.*;
import java.util.*;

public class Main {
	static int N, res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		res = 0;
		back(0, board);
		System.out.print(res);
	}
	
	public static void back(int depth, int[][] board) {
		if (depth == 5) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					res = Math.max(res, board[i][j]);
				}
			}
			return;
		}
		int[][] newBoard = board;
		for (int i = 0; i < 4; i++) {
			back(depth + 1, moveLeftBoard(newBoard = spinBoard(newBoard)));
		}
	}
	
	public static int[][] spinBoard(int[][] board) {
		int[][] newBoard = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				newBoard[i][j] = board[j][N-i-1];
			}
		}
		return newBoard;
	}
	
	public static int[][] moveLeftBoard(int[][] board) {
		int[][] newBoard = new int[N][N];
		boolean[][] plusCheck = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			newBoard[i][0] = board[i][0];
			for (int j = 1; j < N; j++) {
				int x = i, y = j;
				int now = board[x][y];
				while (0 <= y-1) {
					if (newBoard[x][y-1] != 0) {
						if (newBoard[x][y-1] == now && !plusCheck[x][y-1]) {
							newBoard[x][y-1] *= 2;
							plusCheck[x][y-1] = true;
						}
						else newBoard[x][y] = now;
						break;
					}
					y--;
				}
				if (y == 0) newBoard[x][y] = now;
			}
		}
		return newBoard;
	}
}