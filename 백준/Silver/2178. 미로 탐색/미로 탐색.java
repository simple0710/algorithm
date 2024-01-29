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
	static int N, M;
	static int[][] board, visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] nums = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(nums[j]);
			}
		}
		System.out.println(bfs());
	}
	
	public static int bfs() {
		int[] dx = new int[] {-1, 1, 0, 0}, dy = new int[] {0, 0, -1, 1};
		visited = new int[N][M];
		Deque<Place> q = new LinkedList<>();
		q.add(new Place(0, 0));
		visited[0][0] = 1;
		while (!q.isEmpty()) {
			Place now = q.poll();
			if (now.x == N-1 && now.y == M-1) return visited[N-1][M-1];
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < M && board[nx][ny] == 1 && visited[nx][ny] == 0) {
					q.add(new Place(nx, ny));
					visited[nx][ny] = visited[now.x][now.y] + 1; 
				}
			}
		}
		return 0;
	}
}