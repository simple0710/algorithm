import java.io.*;
import java.util.*;

public class Main {
	static class Place {
		int k, x, y;
		Place(int k, int x, int y) {
			this.k = k;
			this.x = x;
			this.y = y;
		}
	}
	static int K, H, W;
	static int[] dk = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, dx = {-1, 1, 0, 0, -2, -2, -1, 1, 2, 2, -1, 1}, dy = {0, 0, -1, 1, -1, 1, 2, 2, -1, 1, -2, -2}; 
	static int[][] board;
	static int[][][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		board = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
		System.out.print(bfs());
	}
	
	public static int bfs() {
		visited = new int[K+1][H][W];
		visited[0][0][0] = 1;
		ArrayDeque<Place> q = new ArrayDeque<>();
		q.add(new Place(0, 0, 0));
		while (!q.isEmpty()) {
			Place now = q.poll();
			if (now.x == H-1 && now.y == W-1) return visited[now.k][now.x][now.y] - 1;
			for (int i = 0; i < 12; i++) {
				int nk = now.k + dk[i];
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nk <= K && 0 <= nx && nx < H && 0 <= ny && ny < W && visited[nk][nx][ny] == 0 && board[nx][ny] != 1) {
					visited[nk][nx][ny] = visited[now.k][now.x][now.y] + 1;
					q.add(new Place(nk, nx, ny));
				}
			}
		}
		return -1;
	}
}