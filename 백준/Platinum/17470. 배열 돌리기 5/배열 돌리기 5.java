import java.io.*;
import java.util.*;

public class Main {
	static class Data {
		int num;
		boolean ud = false;
		boolean lr = false;
		Data(int num) {
			this.num = num;
		}
	}
	static int N, M, spin;
	static int[][] board, resBoard;
	static Data[] numBoard;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		numBoard = new Data[4];
		for (int i = 0; i < 4; i++) numBoard[i] = new Data(i);
		st = new StringTokenizer(br.readLine());
		while (K-- > 0) {
			int cmd = Integer.parseInt(st.nextToken());
			numBoard = miniSpin(cmd);
		}
		resBoard = new int[N][M];
		for (int i = 0; i < 4; i++) {
			Data now = numBoard[i];
			int R1 = (i / 2) * (N / 2);
			int C1 = (i % 2) * (M / 2);
			int R2 = (now.num / 2) * (N / 2);
			int C2 = (now.num % 2) * (M / 2);
			finalSpin(now, N, M, R1, C1, R2, C2);
		}
		if (spin % 2 == 1) {
			resBoard = spin == 1 ? spin3(resBoard) : spin4(resBoard);
			int temp = N;
			N = M; M = temp;
		} else if(spin == 2) {
			for (int i = 0; i < 2; i++) {
				resBoard = spin3(resBoard);
				int temp = N;
				N = M; M = temp;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int[] row : resBoard) {
			for (int v : row) sb.append(v).append(" ");
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	public static Data[] miniSpin(int cmd) {
		if ((cmd == 1 && spin % 2 == 0) || (cmd == 2 && spin % 2 == 1)) return miniSpin1();
		else if ((cmd == 2 && spin % 2 == 0) || (cmd == 1 && spin % 2 == 1)) return miniSpin2();
		else if (cmd == 3) return miniSpin3();
		else if (cmd == 4) return miniSpin4();
		else if (cmd == 5) return miniSpin5();
		else return miniSpin6();
	}
	
	public static Data[] miniSpin1() {
		Data[] newNumBoard = new Data[4];
		for (int i = 0; i < 2; i++) {
			newNumBoard[i] = numBoard[i+2];
			newNumBoard[i+2] = numBoard[i];
			newNumBoard[i].ud = !newNumBoard[i].ud; 
			newNumBoard[i+2].ud = !newNumBoard[i+2].ud; 
		}
		return newNumBoard;
	}
	
	public static Data[] miniSpin2() {
		Data[] newNumBoard = new Data[4];
		for (int i = 0; i < 2; i++) {
			int now = i * 2;
			newNumBoard[now] = numBoard[now+1];
			newNumBoard[now+1] = numBoard[now];
			newNumBoard[now].lr = !newNumBoard[now].lr;
			newNumBoard[now+1].lr = !newNumBoard[now+1].lr;
		}
		return newNumBoard;
	}
	
	public static Data[] miniSpin3() {
		spin = (spin + 1) % 4;
		return numBoard;
	}
	
	public static Data[] miniSpin4() {
		spin = (spin + 3) % 4;
		return numBoard;
	}
	
	public static Data[] miniSpin5() {
		Data[] newNumBoard = new Data[4];
		newNumBoard[0] = numBoard[2];
		newNumBoard[1] = numBoard[0];
		newNumBoard[3] = numBoard[1];
		newNumBoard[2] = numBoard[3];
		return newNumBoard;
	}
	
	public static Data[] miniSpin6() {
		Data[] newNumBoard = new Data[4];
		newNumBoard[0] = numBoard[1];
		newNumBoard[1] = numBoard[3];
		newNumBoard[2] = numBoard[0];
		newNumBoard[3] = numBoard[2];
		return newNumBoard;
	}
	
	public static void finalSpin(Data now, int N, int M, int r1, int c1, int r2, int c2) {
		if (now.ud) spin1(r2, c2);
		if (now.lr) spin2(r2, c2);
		for (int i = r1; i < r1 + N/2; i++) {
			for (int j = c1 ; j < c1 + M/2; j++) {
				resBoard[i][j] = board[r2+i-r1][c2+j-c1];
			}
		}
	}
	
	public static void spin1(int r, int c) {
		for (int i = r; i < r + N/4; i++) {
			for (int j = c; j < c + M/2; j++) {
				int temp = board[i][j];
				board[i][j] = board[(r + N/2)-1-i+r][j];
				board[(r + N/2)-1-i+r][j] = temp;
			}
		}
	}
	
	public static void spin2(int r, int c) {
		for (int i = r; i < r + N/2; i++) {
			for (int j = c; j < c + M/4; j++) {
				int temp = board[i][j];
				board[i][j] = board[i][(c + M/2)-1-j+c];
				board[i][(c + M/2)-1-j+c] = temp;
			}
		}
	}
	
	public static int[][] spin3(int[][] board) {
		int[][] newBoard = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				newBoard[i][j] = board[N-1-j][i];
			}
		}
		return newBoard;
	}
	
	public static int[][] spin4(int[][] board) {
		int[][] newBoard = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				newBoard[i][j] = board[j][M-1-i];
			}
		}
		return newBoard;
	}
}