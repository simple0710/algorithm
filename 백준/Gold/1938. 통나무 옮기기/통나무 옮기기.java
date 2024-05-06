import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] bCenter, eCenter;
	static int[] dx = {-1, 1, 0, 0, 0}, dy = {0, 0, -1, 1, 0}, dz = {0, 0, 0, 0, 1};
	static char[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new char[N][N];
		bCenter = new int[3];
		bCenter[0] = -1;
		eCenter = new int[3];
		eCenter[0] = -1;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) board[i][j] = str.charAt(j);
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 'B') {
					if (bCenter[0] == -1) bCenter = getCenter(i, j);
					board[i][j] = '0';
				}
				if (board[i][j] == 'E') {
					if (eCenter[0] == -1) eCenter = getCenter(i, j);
					board[i][j] = '0';
				}
			}
		}
		System.out.print(bfs());
	}
	
	private static int bfs() {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.add(bCenter);
		int[][][] visited = new int[2][N][N];
		while (!q.isEmpty()) {
			int[] now = q.poll();
			if (now[0] == eCenter[0] && now[1] == eCenter[1] && now[2] == eCenter[2]) return visited[now[0]][now[1]][now[2]];
			for (int i = 0; i < 5; i++) {
				int nTurn = (now[0] + dz[i]) % 2;
				int nx = now[1] + dx[i];
				int ny = now[2] + dy[i];
				int nnx = nx;
				int nny = ny;
				if ((nTurn == 0 && i >= 2) || (nTurn == 1 && i <= 1)) {
					nnx += dx[i];
					nny += dy[i];
				}
				boolean flag = true;
				if (i == 4) {
					for (int v = -1; v < 2; v++) {
						for (int v2 = -1; v2 < 2; v2++) {
							int tv = now[1] + v;
							int tv2 = now[2] + v2;
							if (isOut(tv, tv2) || board[tv][tv2] == '1') flag = false;
						}
					}
				}
				if (flag && !isOut(nnx, nny) && !isWall(nTurn, nx, ny) && visited[nTurn][nx][ny] == 0) {
					q.add(new int[] {nTurn, nx, ny});
					visited[nTurn][nx][ny] = visited[now[0]][now[1]][now[2]] + 1;
				}

			}
		}
		return 0;
	}
	
	public static boolean isWall(int d, int x, int y) {
		if (d == 1) {
			for (int i = 0; i <= 1; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (!isOut(nx, ny) && board[nx][ny] == '1') return true;
			}
		} else if (d == 0) {
			for (int i = 2; i <= 3; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (!isOut(nx, ny) && board[nx][ny] == '1') return true;
			}
		}
		return board[x][y] == '1';
	}

	public static boolean isOut(int x, int y) {
		return 0 > x || x >= N || 0 > y || y >= N;
	}
	
	public static int[] getCenter(int x, int y) {
		int[] newCenter = new int[3];
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (!isOut(nx, ny) && board[nx][ny] == board[x][y]) {
				newCenter = new int[] {d <= 1 ? 1 : 0, nx, ny};
			}
		}
		return newCenter;
	}
}
