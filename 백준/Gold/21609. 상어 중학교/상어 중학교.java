import java.io.*;
import java.util.*;

public class Main {
	static class Place {
		int x;
		int y;
		Place(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int N, M;
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
	static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int res = 0;
		while (true) {
			int[] output = findBlockArea();
			int B = output[2] + output[3];
			if (B < 2) break;
			res += B * B;
			int x = output[0];
			int y = output[1];
			delete(board[x][y], x, y, new boolean[N][N]);
			gravity();
			board = spin();
			gravity();
		}
		System.out.print(res);
	}

	private static int[] findBlockArea() {
		boolean[][] visited = new boolean[N][N];
		int[] output = new int[4];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && board[i][j] > 0) {
					int[] now = bfs(board[i][j], i, j, visited);
					if (now[0] + now[1] >= 2) {
						if (now[0] + now[1] > output[2] + output[3]) {
							output = new int[] {i, j, now[0], now[1]};
						} else if (now[0] + now[1] == output[2] + output[3] && now[1] >= output[3]) {
							output = new int[] {i, j, now[0], now[1]};
						}
					}
				}
			}
		}
		return output;
	}

	private static int[] bfs(int color, int x, int y, boolean[][] visited) {
		ArrayDeque<Place> q = new ArrayDeque<>();
		boolean[][] smallVisited = new boolean[N][N];
		smallVisited[x][y] = true;
		visited[x][y] = true;
		q.add(new Place(x, y));
		int rainbow = 0;
		int normal = 1;
		while (!q.isEmpty()) {
			Place now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (!isOut(nx, ny) && !smallVisited[nx][ny]) {
					if (board[nx][ny] == color || board[nx][ny] == 0) {
						if (board[nx][ny] == color) {
							normal++;
							visited[nx][ny] = true;
						} else rainbow++;
						smallVisited[nx][ny] = true;
						q.add(new Place(nx, ny));
					}
				}
			}
		}
		return new int[] {normal, rainbow};
	}
	
	private static void delete(int color, int x, int y, boolean[][] visited) {
		if (isOut(x, y) || (board[x][y] != color && board[x][y] != 0) || visited[x][y]) return;
		visited[x][y] = true;
		board[x][y] = -2;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			delete(color, nx, ny, visited);
		}
	}
	
	private static void gravity() {
		for (int j = 0; j < N; j++) {
			for (int i = N-2; i >= 0; i--) {
				if (board[i][j] >= 0) {
					int now = i;
					while (now + 1 < N && board[now+1][j] == -2) now++;
					board[now][j] = board[i][j];
					if (now != i) board[i][j] = -2;
				}
			}
		}
	}
	
	private static int[][] spin() {
		int[][] newBoard = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				newBoard[N-j-1][i] = board[i][j];
			}
		}
		return newBoard;
	}
	
	private static boolean isOut(int x, int y) {
		return x < 0 || x >= N || y < 0 || y >= N;
	}
}