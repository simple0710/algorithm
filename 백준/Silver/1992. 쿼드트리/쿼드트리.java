import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder(); 
	static int[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] row = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(row[j]);
			}
		}
		//큰 범위부터 작은 범위로 탐색
		// N지점 -> 왼, 왼 위, 위 탐색
		// 2의 N제곱으로 주어짐
//		2 4 8 16 32 64 128..
		recur(N, 0, 0);
		System.out.print(sb);
	}
	public static void recur(int nowN, int startX, int startY) {
		int now = board[startX][startY];
		if (nowN == 1) {
			sb.append(now);
			return;
		}
		boolean flag = true;
		for (int i = startX; i < startX + nowN; i++) {
			for (int j = startY; j < startY + nowN; j++) {
				if (now != board[i][j]) flag = false;
			}
		}
		if (flag) {
			sb.append(now);
			return;
		}
		sb.append("(");
		int nextN = nowN/2;
		recur(nextN, startX, startY);
		recur(nextN, startX, startY + nextN);
		recur(nextN, startX + nextN, startY);
		recur(nextN, startX + nextN, startY + nextN);
		sb.append(")");
	}
}