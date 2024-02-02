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
	static int W, H;
	static int[][] visited;
	static char[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			board = new char[H][];
			visited = new int[H][W];
			ArrayDeque<Place> q = new ArrayDeque<>();
			ArrayDeque<Place> fq = new ArrayDeque<>();
			for (int i = 0; i < H; i++) {
				board[i] = br.readLine().toCharArray();
				for (int j = 0; j < W; j++) {
					if (board[i][j] == '@') q.add(new Place(i, j));
					else if (board[i][j] == '*') {
						fq.add(new Place(i, j));
						visited[i][j] = 1;
					}
				}
			}
			bfs(fq, false);
			sb.append(bfs(q, true)).append("\n");
		}
		System.out.print(sb);
	}
	public static String bfs(ArrayDeque<Place> q, boolean flag) {
		int[] dx = new int[] {-1, 1, 0, 0}, dy = new int[] {0, 0, -1, 1};
		if (flag) visited[q.getFirst().x][q.getFirst().y] = 1;
		while (!q.isEmpty()) {
			Place now = q.poll();
			if (flag && (now.x == 0 || now.x == H-1 || now.y == 0 || now.y == W-1)) return String.valueOf(visited[now.x][now.y]);
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (0 <= nx && nx < H && 0 <= ny && ny < W && board[nx][ny] != '#') {
					if (visited[nx][ny] == 0 || visited[nx][ny] > visited[now.x][now.y] + 1) {
						q.add(new Place(nx, ny));
						visited[nx][ny] = visited[now.x][now.y] + 1; 
					}
				}
			}
		}
		return "IMPOSSIBLE";
	}
}