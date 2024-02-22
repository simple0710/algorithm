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
	static int N, M;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static boolean flag;
	static String[][] board;
	static Place end;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new String[N][M];
		ArrayDeque<Place> bq = new ArrayDeque<>(), q = new ArrayDeque<>();
		boolean[][] visited1 = new boolean[N][M];
		boolean[][] visited2 = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				if (board[i][j].equals("L")) {
					board[i][j] = ".";
					if(bq.isEmpty()) {
						visited1[i][j] = true;
						bq.add(new Place(i, j));
					} else end = new Place(i, j);
				}
				if (board[i][j].equals(".")) {
					visited2[i][j] = true;
					q.add(new Place(i, j));
				}
			}
		}
		int t = 0;
		while (true) {
			q = bfs(q, visited2, true);
			bq = bfs(bq, visited1, false);
			if (visited1[end.x][end.y]) break;
			t++;
		}
		System.out.print(t);
	}
	
	public static ArrayDeque<Place> bfs(ArrayDeque<Place> q, boolean[][] visited, boolean flag) {
		ArrayDeque<Place> newQ = new ArrayDeque<>();
		while (!q.isEmpty()) {
			Place now = q.poll();
			if (flag) board[now.x][now.y] = ".";
			else if (end.equals(now)) {
				newQ.clear();
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny]) {
					visited[nx][ny] = true;
					if (board[nx][ny].equals("X")) newQ.add(new Place(nx, ny));
					else q.add(new Place(nx, ny));
				}
			}
		}
		return newQ;
	}
}