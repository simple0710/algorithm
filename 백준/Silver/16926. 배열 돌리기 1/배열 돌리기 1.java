import java.io.*;
import java.util.*;

public class Main {
	static int N, M, R;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		int[][] board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while (R-- > 0) board = spin(board);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] spin(int[][] board) {
		int[][] newBoard = new int[N][M];
		for (int i = 0; i < N / 2; i++) {
			for (int j = i; j < M-1-i; j++) {
				newBoard[i][j] = board[i][j+1];
				newBoard[N-1-i][M-1-j] = board[N-1-i][M-2-j];
			}
		}
		for (int j = 0; j < M / 2; j++) {
			for (int i = j+1; i < N-j; i++) {
				newBoard[i][j] = board[i-1][j];
				newBoard[N-1-i][M-1-j] = board[N-i][M-1-j];
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (newBoard[i][j] == 0) newBoard[i][j] = board[i][j];
			}
		}
		return newBoard;
	}
}