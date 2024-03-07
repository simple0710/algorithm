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
	static int N, M, K;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static char[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		board = new char[N][];
		for (int i = 0; i < N; i++) board[i] = br.readLine().toCharArray();
		System.out.print(bfs());
	}
	
	public static int bfs() {
		ArrayDeque<Place> q = new ArrayDeque<>();
		int[][][] visited = new int[K+1][N][M];
		q.add(new Place(0, 0, 0));
		visited[0][0][0] = 1;
		while (!q.isEmpty()) {
			Place now = q.poll();
			if (now.x == N - 1 && now.y == M - 1) return visited[now.k][now.x][now.y];
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				int nk = now.k;
				if (0 <= nx && nx < N && 0 <= ny && ny < M) {
					if (board[nx][ny] == '1') nk++;
					if (nk <= K && visited[nk][nx][ny] == 0) {
						visited[nk][nx][ny] = visited[now.k][now.x][now.y] + 1; 
						q.add(new Place(nk, nx, ny));
					}
				}
			}
		}
		return -1;
	}
}