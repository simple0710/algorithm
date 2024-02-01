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
	
	static boolean resFlag;
	static int R, C;
	static int[][] visited;
	static char[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][];
		visited = new int[R][C];
		Deque<Place> q = new LinkedList<>();
		Deque<Place> fq = new LinkedList<>();
		for (int r = 0; r < R; r++) {
			board[r] = br.readLine().toCharArray();
			for (int c = 0; c < C; c++) {
				if (board[r][c] == 'J') {
					q.add(new Place(r, c));
					visited[r][c] = 1;
				}
				else if (board[r][c] == 'F') {
					fq.add(new Place(r, c));
					visited[r][c] = 1;
				}
			}
		}
		
		System.out.print(bfs(q, fq));
	}

	public static String bfs(Deque<Place> q, Deque<Place> fq) {
		int turn = 1;
		while (!q.isEmpty()) {
            fq = search(fq, false);
			q = search(q, true);
			if (resFlag) return String.valueOf(turn);
			turn++;
		}
		return "IMPOSSIBLE";
	}
	
	public static Deque<Place> search(Deque<Place> q, boolean flag) {
		int[] dx = new int[] { -1, 1, 0, 0 }, dy = new int[] { 0, 0, -1, 1 };
		Deque<Place> newQ = new LinkedList<>();
		while (!q.isEmpty()) {
			Place now = q.poll();
			if (flag && (now.x == 0 || now.x == R - 1 || now.y == 0 || now.y == C - 1)) resFlag = true;
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (0 <= nx && nx < R && 0 <= ny && ny < C && board[nx][ny] != '#' && visited[nx][ny] == 0) {
					visited[nx][ny] = visited[now.x][now.y] + 1;
					newQ.add(new Place(nx, ny));
				}
			}
		}
		return newQ;
	}
}