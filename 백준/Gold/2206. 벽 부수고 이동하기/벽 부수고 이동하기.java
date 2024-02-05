import java.io.*;
import java.util.*;

public class Main {
	static class Place {
		int z;
		int x;
		int y;
		Place(int z, int x, int y) {
			this.z = z;
			this.x = x;
			this.y = y;
		}
	}
	static int N, M;
	static int[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			char[] row = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				board[i][j] = row[j] - '0';
			}
		}
		System.out.print(bfs());
	}
	public static int bfs() {
		int[] dx = new int[] {-1, 1, 0, 0}, dy = new int[] {0, 0, -1, 1};
		ArrayDeque<Place> q = new ArrayDeque<>();
		int[][][] visited = new int[2][N][M];
		visited[0][0][0] = 1;
		q.add(new Place(0, 0, 0));
		while (!q.isEmpty()) {
			Place now = q.poll();
			if (now.x == N-1 && now.y == M-1) return visited[now.z][now.x][now.y];
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < M) {
					int nz = now.z;
					if (board[nx][ny] == 1) nz++;
					if (nz < 2 && visited[nz][nx][ny] == 0) {
						q.add(new Place(nz, nx, ny));
						visited[nz][nx][ny] = visited[now.z][now.x][now.y] + 1; 
					}
				}
			}
		}
		return -1;
	}
}