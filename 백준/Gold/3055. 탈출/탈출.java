import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int[][] visited;
	static char[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		ArrayDeque<int[]> q1 = new ArrayDeque<>();
		ArrayDeque<int[]> q2 = new ArrayDeque<>();
		int gx = 0, gy = 0;
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 'S') q1.add(new int[] {i, j});
				else if (board[i][j] == '*') q2.add(new int[] {i, j});
				else if (board[i][j] == 'D') {
					gx = i; gy = j;
				}
			}
		}
		visited = new int[N][M];
		while (!q1.isEmpty()) {
			bfs(true, q1);
			bfs(false, q2);
		}
		System.out.print(visited[gx][gy] != 0 ? visited[gx][gy] : "KAKTUS");
	}
	
	private static void bfs(boolean who, ArrayDeque<int[]> q) {
		int size = q.size();
		while (size-- > 0) {
			int[] now = q.poll();
			if (who && board[now[0]][now[1]] == '*') continue; 
			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < M && board[nx][ny] != 'X') {
					if (who) {
						if (board[nx][ny] != '*' && visited[nx][ny] == 0) {
							visited[nx][ny] = visited[now[0]][now[1]] + 1;
							q.add(new int[] {nx, ny});
						}
					} else {
						if (board[nx][ny] != '*' && board[nx][ny] != 'D') {
							board[nx][ny] = '*';
							q.add(new int[] {nx, ny});
						}
					}
				}
			}
		}
	}
}