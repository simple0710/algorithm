import java.io.*;
import java.util.*;

public class Main {
	static class Place {
		int cnt;
		int rx;
		int ry;
		int bx;
		int by;
		Place(int cnt, int rx, int ry, int bx, int by) {
			this.cnt = cnt;
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
		}
	}

	static int N, M, rx, ry, bx, by;
	static int[] dx = new int[] { -1, 0, 1, 0 }, dy = new int[] { 0, -1, 0, 1 };
	static char[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
			for (int j = 1; j < M - 1; j++) {
				if (board[i][j] == 'R') {
					rx = i;
					ry = j;
					board[i][j] = '.';
				} else if (board[i][j] == 'B') {
					bx = i;
					by = j;
					board[i][j] = '.';
				}
			}
		}
		System.out.print(Solution());
	}

	public static int Solution() {
		ArrayDeque<Place> q = new ArrayDeque<>();
		boolean[][][][] visited = new boolean[N][M][N][M];
		q.add(new Place(0, rx, ry, bx,by));
		visited[rx][ry][bx][by] = true;
		while (!q.isEmpty()) {
			Place now = q.poll();
			if (now.cnt >= 10) break;
			for (int i = 0; i < 4; i++) {
				int[] blueP;
				int[] redP;
				redP = Move(now.rx, now.ry, i);
				blueP = Move(now.bx, now.by, i);
				if (board[blueP[0]][blueP[1]] == 'O') continue;
				if (board[redP[0]][redP[1]] == 'O') return now.cnt + 1;
				if (redP[0] == blueP[0] && redP[1] == blueP[1]) {
					if (redP[2] < blueP[2]) {
						blueP[0] -= dx[i];
						blueP[1] -= dy[i];
					} else {
						redP[0] -= dx[i];
						redP[1] -= dy[i];
					}
				}
				if (!visited[redP[0]][redP[1]][blueP[0]][blueP[1]]) {
					visited[redP[0]][redP[1]][blueP[0]][blueP[1]] = true;
					q.add(new Place(now.cnt + 1, redP[0], redP[1], blueP[0], blueP[1]));
				}
			}
		}
		return -1;
	}

	public static int[] Move(int x, int y, int d) {
		int cnt = 0;
		while (board[x + dx[d]][y + dy[d]] != '#' && board[x][y] != 'O') {
			x += dx[d];
			y += dy[d];
			cnt++;
		}
		return new int[] { x, y, cnt };
	}
}