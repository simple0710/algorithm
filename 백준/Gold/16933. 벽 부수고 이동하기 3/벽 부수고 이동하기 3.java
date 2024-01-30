import java.io.*;
import java.util.*;

public class Main {
	static class Place {
		int day;
		int k;
		int x;
		int y;

		Place(int day, int k, int x, int y) {
			this.day = day;
			this.k = k;
			this.x = x;
			this.y = y;
		}
	}

	static int N, M, K;
	static int[][] board;
	static int[][][][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()) + 1;
		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] strArr = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(strArr[j]);
			}
		}
		System.out.print(bfs());
	}
	public static int bfs() {
		int[] dx = new int[] { 1, 0, 0, -1 }, dy = new int[] { 0, 1, -1, 0 };
		visited = new int[2][K][N][M];
		Deque<Place> q = new LinkedList<>();
		visited[0][0][0][0] = 1;
		q.add(new Place(0, 0, 0, 0));
		int res = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			Place now = q.poll();
			if (now.x == N-1 && now.y == M-1) res = Math.min(res, visited[now.day][now.k][now.x][now.y]); 
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < M) {
					int nowMoveCnt = visited[now.day][now.k][now.x][now.y];
					if (board[nx][ny] == 0) {
						if (visited[1-now.day][now.k][nx][ny] == 0 || visited[1-now.day][now.k][nx][ny] > nowMoveCnt + 1) {
							visited[1-now.day][now.k][nx][ny] = nowMoveCnt + 1;
							q.addLast(new Place(1-now.day, now.k, nx, ny));
						}
					} else {
						if (now.k+1 == K) continue;
						int nd = now.day;
						if (nd == 1) {
							nd = 1 - nd;
							nowMoveCnt++;
						}
						if (visited[1-nd][now.k+1][nx][ny] == 0 || visited[1-nd][now.k+1][nx][ny] > nowMoveCnt + 1) {
							visited[1-nd][now.k+1][nx][ny] = nowMoveCnt + 1;
							q.addFirst(new Place(1-nd, now.k+1, nx, ny));
						}
					}
				}
			}
		}
		return res == Integer.MAX_VALUE ? -1 : res;
	}
}