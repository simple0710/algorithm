import java.io.*;
import java.util.*;

public class Main {
	static int N, M, res;
	static boolean[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new boolean[N+1][M+1];
		res = 1;
		back(0, 0);
		System.out.print(res);
	}
	
	public static void back(int depth, int start) {
		if (depth == N * M) return;
		for (int i = start; i < N * M; i++) {
			int x = i / M + 1;
			int y = i % M + 1;
			if (check(x, y)) {
				res++;
				board[x][y] = true;
				back(depth + 1, i + 1);
				board[x][y] = false;
			}
		}
	}
	
	public static boolean check(int x, int y) {
		return !(board[x-1][y-1] && board[x-1][y] && board[x][y-1]);
	}
}