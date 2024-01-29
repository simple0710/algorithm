import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static class Place {
		int f;
		int x;
		int y;

		Place(int f, int x, int y) {
			this.f = f;
			this.x = x;
			this.y = y;
		}
	}

	static int N, M;
	static int[][] board;
	static int[][][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];

		for (int i = 0; i < N; i++) {
			String[] nums = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(nums[j]);
			}
		}
		System.out.print(bfs());
	}

	public static int bfs() {
		int[] dx = new int[] { -1, 1, 0, 0 }, dy = new int[] { 0, 0, -1, 1 };
		Deque<Place> q = new LinkedList<>();
		visited = new int[2][N][M];
		visited[0][0][0] = 1;
		q.add(new Place(0, 0, 0));
		while (!q.isEmpty()) {
			Place now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < M) {
					if (board[nx][ny] == 1) {
						if (now.f == 0 && visited[now.f+1][nx][ny] == 0) {
							visited[now.f + 1][nx][ny] = visited[now.f][now.x][now.y] + 1;
							q.add(new Place(now.f+1, nx, ny));
						}
					} else {
						if (visited[now.f][nx][ny] == 0) {
							visited[now.f][nx][ny] = visited[now.f][now.x][now.y] + 1;
							q.add(new Place(now.f, nx, ny));
						}
					}
				}
			}
		}
		int res = Integer.MAX_VALUE;
		if (visited[0][N-1][M-1] != 0) res = visited[0][N-1][M-1];
		if (visited[1][N-1][M-1] != 0) res = Math.min(res, visited[1][N-1][M-1]);
		return res != Integer.MAX_VALUE ? res : -1;
	}
}