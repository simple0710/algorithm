import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] board;
	static long[][] visited;
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
		visited = new long[N][N];
		System.out.print(dfs(0, 0));
	}
	
	public static long dfs(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N) return 0;
		else if (x == N-1 && y == N-1) return 1;
		else if (visited[x][y] > 0) return visited[x][y];
		else if (board[x][y] == 0) return 0;
		for (int[] v : new int[][] {{1, 0}, {0, 1}}) {
			int nx = x + v[0] * board[x][y];
			int ny = y + v[1] * board[x][y];
			visited[x][y] += dfs(nx, ny);
		}
		return visited[x][y];
	}
}