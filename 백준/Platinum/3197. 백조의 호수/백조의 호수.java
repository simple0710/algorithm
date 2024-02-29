import java.io.*;
import java.util.*;

public class Main {
	public static class Place {
		int x;
		int y;
		Place(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int R, C;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static char[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		boolean[][] visited1 = new boolean[R][C];
		boolean[][] visited2 = new boolean[R][C];
		board = new char[R][C];
		ArrayDeque<Place> bird = new ArrayDeque<>();
		ArrayDeque<Place> water = new ArrayDeque<>();
		Place end = null;
		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (board[i][j] == 'L') {
					board[i][j] = '.';
					if (bird.isEmpty()) bird.add(new Place(i, j));
					else end = new Place(i, j);
				}
				if (board[i][j] == '.') {
					water.add(new Place(i, j));
					visited1[i][j] = true;
				}
			}
		}
		int t = 1;
		while (true) {
			water = bfs(water, visited1, true);
			bird = bfs(bird, visited2, false);
			if (visited2[end.x][end.y]) break;
			t++;
		}
		System.out.print(t);
	}
	public static ArrayDeque<Place> bfs(ArrayDeque<Place> q, boolean[][] visited, boolean flag) {
		ArrayDeque<Place> newQ = new ArrayDeque<>();
		while (!q.isEmpty()) {
			Place now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (0 <= nx && nx < R && 0 <= ny && ny < C && !visited[nx][ny]) {
					visited[nx][ny] = true;
					if (board[nx][ny] == 'X') {
						newQ.add(new Place(nx, ny));
						if (flag) board[nx][ny] = '.';
					} else q.add(new Place(nx, ny));
				}
			}
		}
		return newQ;
	}
}