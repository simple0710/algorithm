import java.io.*;
import java.util.*;

public class Main {
	static int R, C;
	static int[] dx = new int[] {-1, 0, 1};
	static char[][] board;
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		for (int i = 0; i < R; i++) board[i] = br.readLine().toCharArray();
		int res = 0;
		for (int i = 0; i < R; i++) {
			flag = false;
			dfs(i, 0);
			if (flag) res++;
		}
		System.out.print(res);
	}
	public static void dfs(int x, int y) {
		if (y == C - 1) {
			flag = true;
			return;
		}
		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + 1;
			if (0 <= nx && nx < R && board[nx][ny] == '.') {
				board[nx][ny] = 'x';
				dfs(nx, ny);
				if (flag) return;
			}
		}
	}
}