import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static class Place {
		int k;
		int x;
		int y;

		Place(int k, int x, int y) {
			this.k = k;
			this.x = x;
			this.y = y;
		}
	}

	static int N, M, K;
	static int[][] board;
	static int[][][] visited;

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
		System.out.println(bfs());
	}

	public static int bfs() {
		int[] dx = new int[] { -1, 1, 0, 0 }, dy = new int[] { 0, 0, -1, 1 };
		visited = new int[K][N][M];
		Deque<Place> q = new LinkedList<>();
		visited[0][0][0] = 1;
		q.add(new Place(0, 0, 0));
		while (!q.isEmpty()) {
			Place now = q.poll();
			if (now.x == N-1 && now.y == M-1) return visited[now.k][now.x][now.y]; 
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < M) {
					int nk = now.k;
					if (board[nx][ny] == 1) {
						nk++;
						if (nk == K) continue;
					}
					if (visited[nk][nx][ny] == 0) {
						visited[nk][nx][ny] = visited[now.k][now.x][now.y] + 1;
						q.add(new Place(nk, nx, ny));
					}
				}
			}
		}
		return -1;
	}
}