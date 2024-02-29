import java.io.*;
import java.util.*;

public class Solution {
	static class Data {
		int idx;
		int x;
		int y;
		int d;
		int K;
		int cnt = 0;
		boolean flag = false;
		Data(int idx, int x, int y, int d, int K) {
			this.idx = idx;
			this.x = x;
			this.y = y;
			this.d = d;
			this.K = K;
		}
	}
	static int res, outCnt;
	static int[] dx = {1, 0, -1, 0}, dy = {0, -1, 0, 1};
	static int[][] board;
	static ArrayList<Data> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			board = new int[2001][2001];
			list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()) + 1000;
				int y = Integer.parseInt(st.nextToken()) + 1000;
				int d = Integer.parseInt(st.nextToken());
				int K = Integer.parseInt(st.nextToken());
				if (d == 1) d = 2;
				else if (d == 2) d = 1;
				list.add(new Data(i+1, y, x, d, K));
				board[y][x] = i + 1;
			}
			res = 0;
			outCnt = 0;
			while (outCnt < N) move();
			System.out.print(String.format("#%d %d\n", t, res));
		}
	}
	public static void move() {
		for (Data now : list) {
			if (now.flag) continue;
//			board[now.x][now.y] = 0;
			now.cnt++;
			now.x += dx[now.d];
			now.y += dy[now.d];
			if (now.x < 0 || now.x >= 2001 || now.y < 0 || now.y >= 2001) {
				now.flag = true;
				outCnt++;
				continue;
			}
			if (board[now.x][now.y] > 0) {
				Data next = list.get(board[now.x][now.y]-1);
				if (now.x == next.x && now.y == next.y) {
					if ((now.d + 2) % 4 == next.d && now.cnt - 1 == next.cnt && !next.flag) {
						res += now.K + next.K;
						now.flag = true;
						next.flag = true;
						outCnt += 2;
						board[next.x][next.y] = 0;
						continue;
					}
					else if (now.cnt == next.cnt) {
						if (!next.flag) {
							res += next.K;
							outCnt++;
							next.flag = true;
						}
						res += now.K;
						now.flag = true;
						outCnt++;
						continue;
					}
				}
			}
			board[now.x][now.y] = now.idx;
		}
	}
}