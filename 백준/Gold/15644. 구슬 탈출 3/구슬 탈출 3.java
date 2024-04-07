import java.io.*;
import java.util.*;

public class Main {
	static class Place {
		int bx;
		int by;
		int rx;
		int ry;
		int turn;
		String move = "";
		Place (String move, int... data) {
			this.bx = data[0];
			this.by = data[1];
			this.rx = data[2];
			this.ry = data[3];
			this.turn = data[4];
			this.move += move;
		}
	}
	static int N, M;
	static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
	static char[][] board;
	static String[] ds = {"U", "L", "D", "R"};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		N = Integer.parseInt(st[0]);
		M = Integer.parseInt(st[1]);
		board = new char[N][M];
		int[] blue = null;
		int[] red = null;
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
			for (int j = 1; j < M-1; j++) {
				if (board[i][j] != '.') {
					if (board[i][j] == 'B') blue = new int[] {i, j};
					else if (board[i][j] == 'R') red = new int[] {i, j};
				}
			}
		}
		bfs(blue, red);
	}
	
	private static void bfs(int[] blue, int[] red) {
		boolean[][][][] visited = new boolean[N][M][N][M];
		ArrayDeque<Place> q = new ArrayDeque<>();
		q.add(new Place("", blue[0], blue[1], red[0], red[1], 0));
		while (!q.isEmpty()) {
			Place now = q.poll();
			if (now.turn >= 10) continue;
			for (int d = 0; d < 4; d++) {
				int[] nBlue = getNextPlace(now.bx, now.by, d);
				int[] nRed = getNextPlace(now.rx, now.ry, d);
				if (nBlue[3] == 1) continue;
				if (nRed[3] == 1) {
					System.out.println(now.turn+1);
					System.out.print(now.move+ds[d]);
					return;
				}
				if (nBlue[0] == nRed[0] && nBlue[1] == nRed[1]) {
					if (now.bx == now.rx) {
						if (nBlue[2] < nRed[2]) nRed[1] -= dy[d]; 
						else nBlue[1] -= dy[d];
					} else if (now.by == now.ry) {
						if (nBlue[2] < nRed[2]) nRed[0] -= dx[d]; 
						else nBlue[0] -= dx[d];
					}
				}
				if (!visited[nBlue[0]][nBlue[1]][nRed[0]][nRed[1]]) {
					visited[nBlue[0]][nBlue[1]][nRed[0]][nRed[1]] = true;
					q.add(new Place(now.move+ds[d], nBlue[0], nBlue[1], nRed[0], nRed[1], now.turn+1));
				}
			}
		}
		System.out.print(-1);
	}

	private static int[] getNextPlace(int x, int y, int d) {
		int nx = x, ny = y, flag = 0;
		while (board[nx+dx[d]][ny+dy[d]] != '#') {
			nx += dx[d];
			ny += dy[d];
			if (board[nx][ny] == 'O') flag = 1;
		}
		return new int[] {nx, ny, Math.abs(nx-x + ny-y), flag};
	}
}