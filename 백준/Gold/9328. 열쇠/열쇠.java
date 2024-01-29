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
	static char[][] board;
	static boolean[] keyFlag;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			board = new char[N + 2][M + 2];
			Arrays.fill(board[0], '.');
			for (int i = 1; i < N+1; i++) {
				char[] p = br.readLine().toCharArray();
				board[i][0] = '.';
				for (int j = 1; j < M + 1; j++) {
					board[i][j] = p[j - 1];
				}
				board[i][M + 1] = '.';
			}
			Arrays.fill(board[N + 1], '.');

			char[] keys = br.readLine().toCharArray();
			keyFlag = new boolean[26];
			if (keys[0] != '0') {
				for (int i = 0; i < keys.length; i++) {
					keyFlag[keys[i] - 'a'] = true;
				}
			}
			System.out.println(bfs());
		}
	}

	public static int bfs() {
		int[] dx = new int[] { -1, 1, 0, 0 }, dy = new int[] { 0, 0, -1, 1 };
		visited = new boolean[N+2][M+2];
		Deque<Place> q = new LinkedList<>();
		visited[0][0] = true;
		q.add(new Place(0, 0));
		int cnt = 0;
		while (!q.isEmpty()) {
			Place now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (0 <= nx && nx < (N + 2) && 0 <= ny && ny < (M + 2) && board[nx][ny] != '*' && !visited[nx][ny]) {
					if ('A' <= board[nx][ny] && board[nx][ny] <= 'Z') {
						if (!keyFlag[board[nx][ny] - 'A']) {
							continue;
						}
					}
					if ('a' <= board[nx][ny] && board[nx][ny] <= 'z') {
						if (!keyFlag[board[nx][ny] - 'a']) {
							visited = new boolean[N+2][M+2];
							visited[nx][ny] = true;
						}
						keyFlag[board[nx][ny] - 'a'] = true;

					}
					if (board[nx][ny] == '$') cnt++;
					board[nx][ny] = '.';
					visited[nx][ny] = true;
					q.add(new Place(nx, ny));
				}
			}
		}
		return cnt;
	}
}