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
	static int N, M, H, totalTomatoCnt;
	static int[][][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		board = new int[H][N][M];
		totalTomatoCnt = 0;
		Deque<Place> q = new LinkedList<>();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					board[i][j][k] = Integer.parseInt(st.nextToken());
					if (board[i][j][k] == 0) totalTomatoCnt++;
					else if (board[i][j][k] == 1) q.add(new Place(i, j, k));
				}
			}
		}
		System.out.print(bfs(q));
	}

	public static int bfs(Deque<Place> q) {
		int[] dz = {-1, 1, 0, 0, 0, 0}, dx = {0, 0, -1, 1, 0, 0}, dy = {0, 0, 0, 0, -1, 1};
		int cnt = 0;
		int day = 1;
		while (!q.isEmpty()) {
			Place now = q.poll();
			for (int i = 0; i < 6; i++) {
				int nz = now.z + dz[i];
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (0 <= nz && nz < H && 0 <= nx && nx < N && 0 <= ny && ny < M && board[nz][nx][ny] == 0) {
					board[nz][nx][ny] = board[now.z][now.x][now.y] + 1;
					q.add(new Place(nz, nx, ny));
					cnt++;
					day = board[nz][nx][ny];
				}
			}
		}
		return cnt == totalTomatoCnt ? day - 1 : -1;
	}
}