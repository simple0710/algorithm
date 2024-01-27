import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int score;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] blueBoard = new int[6][4];
		int[][] greenBoard = new int[6][4];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			fillBoard(t, x, y, greenBoard);
			if (t == 3) x++;
			fillBoard((5 - t) % 4, y, 3 - x, blueBoard);
			
		}
		System.out.println(score);
		System.out.print(tileCntCheck(greenBoard) + tileCntCheck(blueBoard));
	}

	public static void fillBoard(int t, int x, int y, int[][] board) {
		int row = 0;
		for (int i = 0; i < 6; i++) {
			if (board[i][y] > 0) break;
			if (t == 2 && board[i][y+1] > 0) break;
			row = i;
		}
		board[row][y] = 1;
		if (t == 2) board[row][y+1] = 1;
		else if (t == 3) board[row-1][y] = 1;
		
		scoreCheck(board);
	}
	
	public static void scoreCheck(int[][] board) {
		boolean[] checkRowsArr = new boolean[6];
		for (int i = 0; i < 6; i++) {
			int blockCnt = 0;
			for (int j = 0; j < 4; j++) {
				if (board[i][j] > 0) blockCnt++;
			}
			if (blockCnt == 4) {
				score++;
				for (int j = 0; j < 4; j++) {
					board[i][j] = 0;
				}
				checkRowsArr[i] = true;
			}
		}
		colDown(checkRowsArr, board);
	}
	
	public static void colDown(boolean[] rows, int[][] board) {
		int row = 5;
		for (int i = 5; i >= 0; i--) {
			if (rows[i]) continue;
			for (int j = 0; j < 4; j++) {
				board[row][j] = board[i][j];
			}
			row--;
		}
		zeroOneCheck(board);
	}
	
	public static void zeroOneCheck(int[][] board) {
		int checkCnt = 0;
		for (int i = 0; i < 2; i++) {
			boolean flag = false;
			for (int j = 0; j < 4; j++) {
				if (board[i][j] > 0) {
					flag = true;
				}
			}
			if (flag) checkCnt++;
		}
		rowDown(checkCnt, board);
	}
	
	public static void rowDown(int cnt, int[][] board) {
		for (int i = 5; i >= 2; i--) {
			for (int j = 0; j < 4; j++) {
				board[i][j] = board[i-cnt][j];
				if (cnt > 0) board[i-cnt][j] = 0;
			}
		}
	}
	
	public static int tileCntCheck(int[][] board) {
		int tileCnt = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 4; j++) {
				if (board[i][j] > 0) tileCnt++;
			}
		}
		return tileCnt;
	}
}