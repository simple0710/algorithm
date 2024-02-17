import java.io.*;
import java.util.*;

public class Main {
	static class Info {
		int numCnt;
		int nowMax;
		int nextMax;
		Info(int numCnt, int nowMax, int nextMax) {
			this.numCnt = numCnt;
			this.nowMax = nowMax;
			this.nextMax = nextMax;
		}
	}
	static int N;
	static int[] maxScore;
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
		maxScore = new int[11];
		back(0, board, 0);
		System.out.print(maxScore[10]);
	}
	
	public static void back(int depth, int[][] board, int beforeCnt) {
		Info nowDepthInfo = checkNum(board);
		if (depth == 10) {
			if (maxScore[10] < nowDepthInfo.nowMax) {
				int tmp = nowDepthInfo.nowMax;
				for (int i = 10; i >= 0; i--) {
					maxScore[i] = tmp;
					tmp /= 2;
				}
			};
			return;
		}
		if (maxScore[depth + 1] >= Math.max(nowDepthInfo.nowMax, nowDepthInfo.nextMax)) return;
		int[][] spinBoard = board;
		for (int i = 0; i < 4; i++) {
			back(depth + 1, moveToLeft(spinBoard = spin(spinBoard)), nowDepthInfo.numCnt); 
		}
	}
	
	public static Info checkNum(int board[][]) {
		int numCnt = 0;
		int nowMax = 0;
		int nextMax = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] > 0) {
					numCnt++;
					nowMax = Math.max(nowMax, board[i][j]);
					if (board[i][j] > nextMax) nextMax = findSameNum(board, i, j) ? board[i][j] : nextMax;
				}
			}
		}
		return new Info(numCnt, nowMax, nextMax * 2);
	}
	
	public static boolean findSameNum(int[][] board, int x, int y) {
		int[] dx = new int[] {-1, 1, 0, 0}, dy = new int[] {0, 0, -1, 1};
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			while (0 <= nx && nx < N && 0 <= ny && ny < N) {
				if (board[nx][ny] > 0) {
					if (board[nx][ny] == board[x][y]) return true;
					break;
				}
				nx += dx[i];
				ny += dy[i];
			}
		}
		return false;
	}
	
	public static int[][] spin(int[][] board) {
		int[][] newBoard = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				newBoard[i][j] = board[j][N-1-i];
			}
		}
		return newBoard;
	}
	
	public static int[][] moveToLeft(int[][] board) {
		int[][] newBoard = new int[N][N];
		boolean[][] plusCheck = new boolean[N][N];
		for (int x = 0; x < N; x++) {
			newBoard[x][0] = board[x][0];
			for (int y = 1; y < N; y++) {
				int nowY = y;
				while (0 <= nowY - 1 && newBoard[x][nowY-1] == 0) nowY--;
				if (nowY == 0 || newBoard[x][nowY-1] != board[x][y] || plusCheck[x][nowY-1]) newBoard[x][nowY] = board[x][y];
				else {
					newBoard[x][nowY-1] *= 2;
					plusCheck[x][nowY-1] = true;
				}
			}
		}
		return newBoard;
	}
}