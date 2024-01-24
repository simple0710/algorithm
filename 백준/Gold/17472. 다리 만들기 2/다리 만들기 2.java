import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static class Place {
		int x;
		int y;
		Place(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class Dist {
		int p1;
		int p2;
		int d;
		Dist(int p1, int p2, int d) {
			this.p1 = p1;
			this.p2 = p2;
			this.d = d;
		}
	}

	static int N, M;
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 }, parent;
	static int[][] board, teamColorBoard;
	static boolean[][] resCheck;
	static ArrayList<Dist> distanceData;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		teamColorBoard = new int[N][M];
		int color = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 1 && teamColorBoard[i][j] == 0) {
					paintColor(i, j, color++);
				}
			}
		}
		distanceData = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (teamColorBoard[i][j] > 0) findDistance(i, j, teamColorBoard[i][j]);
			}
		}

		parent = new int[color];
		for (int i = 1; i < color; i++) parent[i] = i;
		Collections.sort(distanceData, new Comparator<Dist>() {
			@Override
			public int compare(Dist o1, Dist o2) {
				return o1.d - o2.d;
			}
		});
		int res = 0;
		resCheck = new boolean[color][color];
		for (Dist now : distanceData) {
			if (find(now.p1) != find(now.p2)) {
				union(now.p1, now.p2);
				res += now.d;
				resCheck[now.p1][now.p2] = true;
				resCheck[now.p2][now.p1] = true;
				
			}
		}
		System.out.print(resSearch(1) ? res : -1);
	}

	public static void paintColor(int x, int y, int color) {
		Deque<Place> q = new LinkedList<>();
		q.add(new Place(x, y));
		teamColorBoard[x][y] = color;
		while (!q.isEmpty()) {
			Place now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < M && board[nx][ny] == 1 && teamColorBoard[nx][ny] == 0) {
					teamColorBoard[nx][ny] = color;
					q.add(new Place(nx, ny));
				}
			}
		}
	}
	
	public static void findDistance(int x, int y, int color) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			while (0 <= nx && nx < N && 0 <= ny && ny < M && teamColorBoard[nx][ny] != color) {
				if (board[nx][ny] != 0) {
					int distance = Math.abs(nx - x) + Math.abs(ny - y);
					if (distance > 2) distanceData.add(new Dist(color, teamColorBoard[nx][ny], distance-1));
					break;
				}
				nx += dx[i];
				ny += dy[i];
			}
		}
	}
	
	public static void union(int x, int y) {
		int o1 = find(x);
		int o2 = find(y);
		parent[Math.max(o1, o2)] = Math.min(o1, o2);
	}
	
	public static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}
	
	public static boolean resSearch(int x) {
		Deque<Integer> q = new LinkedList<>();
		q.add(x);
		boolean[] visited = new boolean[resCheck[0].length];
		visited[0] = true;
		visited[x] = true;
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i = 0; i < resCheck[now].length; i++) {
				if (resCheck[now][i] && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
		for (boolean v : visited) {
			if (!v) return false;
		}
		return true;
	}
}