import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int N, res;
	static int[][] board;
	static int[] dx = {1, 0, 1}, dy = {0, 1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		res = 0;
		dfs(0, 1, 0);
		System.out.println(res);
	}
	
	public static void dfs(int x, int y, int d) {
		if (x < 0 || x >= N || y < 0 || y >= N || board[x][y] == 1) return;
		if (x == N-1 && y == N-1) {
			res++;
			return;
		}
		if (x+1 < N && y+1 < N && board[x+1][y] != 1 && board[x][y+1] != 1) {
			dfs(x+1, y+1, 2);
		}
		
		if (d == 0 || d == 2) dfs(x, y+1, 0);
		if (d == 1 || d == 2) dfs(x+1, y, 1);
	}
}