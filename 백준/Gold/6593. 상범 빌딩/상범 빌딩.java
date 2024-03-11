import java.io.*;
import java.util.*;

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
	static int L, R, C;
	static int[] dk = {-1, 1, 0, 0, 0, 0}, dx = {0, 0, -1, 1, 0, 0}, dy = {0, 0, 0, 0, -1, 1};
	static char[][][] board;
	static Place start;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if (L == 0 && R == 0 && C == 0) break;
			board = new char[L][R][C];
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					board[i][j] = br.readLine().toCharArray();
					for (int k = 0; k < C; k++) {
						if (board[i][j][k] == 'S') start = new Place(i, j, k);
					}
				}
				br.readLine();
			}
			System.out.println(bfs());
		}
	}
	public static String bfs() {
		ArrayDeque<Place> q = new ArrayDeque<>();
		q.add(start);
		int[][][] visited = new int[L][R][C];
		while (!q.isEmpty()) {
			Place now = q.poll();
			if (board[now.k][now.x][now.y] == 'E') return String.format("Escaped in %d minute(s).", visited[now.k][now.x][now.y]);
			for (int i = 0; i < 6; i++) {
				int nk = now.k + dk[i];
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (0 <= nk && nk < L && 0 <= nx && nx < R && 0 <= ny && ny < C && visited[nk][nx][ny] == 0 && board[nk][nx][ny] != '#') {
					visited[nk][nx][ny] = visited[now.k][now.x][now.y] + 1;
					q.add(new Place(nk, nx, ny));
				}
			}
		}
		return "Trapped!";
	}
}