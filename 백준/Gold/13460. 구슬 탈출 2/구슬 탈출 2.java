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
	static int[][][] visited;
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
		System.out.print(getRoot());
	}

	public static int getRoot() {
		ArrayDeque<Place> q = new ArrayDeque<>();
		q.add(new Place(0, rx, ry, bx, by));
		while (!q.isEmpty()) {
			Place now = q.poll();
			if (now.cnt >= 10) break;
			for (int i = 0; i < 4; i++) {
				int[] blueP;
				int[] redP;
				if (now.rx == now.bx || now.ry == now.by) {
					if (now.rx < now.bx || now.ry < now.by) {
						if (i < 2) {
							redP = Move(now.rx, now.ry, now.bx, now.by, i);
							blueP = Move(now.bx, now.by, redP[0], redP[1], i);
						} else {
							blueP = Move(now.bx, now.by, now.rx, now.ry, i);
							redP = Move(now.rx, now.ry, blueP[0], blueP[1], i);
						}
					} else {
						if (i < 2) {
							blueP = Move(now.bx, now.by, now.rx, now.ry, i);
							redP = Move(now.rx, now.ry, blueP[0], blueP[1], i);
						} else {
							redP = Move(now.rx, now.ry, now.bx, now.by, i);
							blueP = Move(now.bx, now.by, redP[0], redP[1], i);
						}
					}
				}
				else {
					redP = Move(now.rx, now.ry, now.bx, now.by, i);
					blueP = Move(now.bx, now.by, now.rx, now.ry, i);
				}
				if (blueP[2] == 0) {
					if (redP[2] == 1) return now.cnt + 1;
					q.add(new Place(now.cnt + 1, redP[0], redP[1], blueP[0], blueP[1]));
				}
			}
		}
		return -1;
	}

	public static int[] Move(int x, int y, int ax, int ay, int d) {
		int nx = x + dx[d];
		int ny = y + dy[d];
		int flag = 0;
		while (board[nx][ny] != '#') {
			if (board[nx][ny] == 'O') flag = 1;
			if (nx == ax && ny == ay) break;
			nx += dx[d];
			ny += dy[d];
		}
		return new int[] { nx - dx[d], ny - dy[d], flag };
	}
}