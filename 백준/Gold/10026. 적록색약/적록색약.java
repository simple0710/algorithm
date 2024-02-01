import java.io.*;

public class Main {
	static int N;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static char[][] board;
	static boolean[][][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new char[N][];
		for (int i = 0; i < N; i++) board[i] = br.readLine().toCharArray();
		int res1 = 0;
		int res2 = 0;
		visited = new boolean[2][N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[0][i][j]) {
					dfs1(board[i][j], 0, i, j);
					res1++;
				}
				if (!visited[1][i][j]) {
					dfs2(board[i][j], 1, i, j);
					res2++;
				}
			}
		}
		System.out.print(res1 + " " + res2);
	}
	public static void dfs1(char color, int w, int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N || visited[w][x][y] || color != board[x][y]) return;
		visited[w][x][y] = true;
		for (int i = 0; i < 4; i++) dfs1(color, w, x + dx[i], y + dy[i]);
	}
	public static void dfs2(char color, int w, int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N || visited[w][x][y]) return;
		else if (board[x][y] == 'B' && color !=  'B') return;
		else if (color == 'B' && board[x][y] != 'B') return;
		visited[w][x][y] = true;
		for (int i = 0; i < 4; i++) dfs2(color, w, x + dx[i], y + dy[i]);
	}
}