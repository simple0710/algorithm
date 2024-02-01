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
	static Deque<Place> q;
	static int[][] board;
	static int N, M, totalTomatoCnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 0) totalTomatoCnt++;
				else if (board[i][j] == 1) q.add(new Place(i, j)); 
			}
		}
		System.out.print(bfs());
	}
	public static int bfs() {
		int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
		int day = 1;
		int cnt = 0;
		while (!q.isEmpty()) {
			Place now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < M && board[nx][ny] == 0) {
					q.add(new Place(nx, ny));
					board[nx][ny] = board[now.x][now.y] + 1;
					day = Math.max(day, board[nx][ny]);
					cnt++;
				}
			}
		}
		return totalTomatoCnt == cnt ? day-1 : -1;
	}
}