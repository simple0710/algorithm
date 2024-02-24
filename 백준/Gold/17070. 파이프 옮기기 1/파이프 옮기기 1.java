import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][][] ch = new int[3][N+1][N+1];
		ch[0][1][2] = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 3; j <= N; j++) {
				if (board[i][j] == 0) {
					ch[0][i][j] = ch[0][i][j-1] + ch[2][i][j-1];
					ch[1][i][j] = ch[1][i-1][j] + ch[2][i-1][j];
					if (board[i][j-1] == 0 && board[i-1][j] == 0) {
						ch[2][i][j] = ch[0][i-1][j-1] + ch[1][i-1][j-1] + ch[2][i-1][j-1];
					}
				}
			}
		}
		System.out.print(ch[0][N][N] + ch[1][N][N] + ch[2][N][N]);
	}
}