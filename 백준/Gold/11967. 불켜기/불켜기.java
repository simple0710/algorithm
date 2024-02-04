import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static class Place {
		int x;
		int y;

		Place(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N;
	static boolean[][] board, visited;
	static LinkedList<Place>[][] switchArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		switchArr = new LinkedList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				switchArr[i][j] = new LinkedList<>();
			}
		}
		board = new boolean[N][N];
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			if (switchArr[x][y] == null) switchArr[x][y] = new LinkedList<>();
			switchArr[x][y].add(new Place(a, b));
		}
		System.out.print(bfs());
	}

	public static int bfs() {
		int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
		Deque<Place> q = new LinkedList<>();
		Deque<Place> darkQ = new LinkedList<>();
		q.add(new Place(0, 0));
		visited = new boolean[N][N];
		visited[0][0] = true;
		board[0][0] = true;
		while (!q.isEmpty()) {
			Place now = q.poll();
			if (switchArr[now.x][now.y] != null) {
				while (switchArr[now.x][now.y].size() > 0) {
					Place light = switchArr[now.x][now.y].poll();
					board[light.x][light.y] = true;
				}
			}
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny]) {
					visited[nx][ny] = true;
					if (board[nx][ny]) {
						q.add(new Place(nx, ny));
					}
					else darkQ.add(new Place(nx, ny));
				}
			}
			if (q.isEmpty()) {
				visited = new boolean[N][N];
				while (!darkQ.isEmpty()) {
					Place p = darkQ.poll();
					if (board[p.x][p.y]) {
						q.add(new Place(p.x, p.y));
						visited[p.x][p.y] = true;
					}
				}
			}
		}
		int res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j]) res++;
			}
		}
		return res;
	}
}