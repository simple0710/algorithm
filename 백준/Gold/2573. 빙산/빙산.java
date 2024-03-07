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
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int[][] board, iceDownCnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ArrayDeque<Place> dfsQ = new ArrayDeque<>();
		ArrayList<Place> iceList = new ArrayList<>();
		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] > 0) {
					iceList.add(new Place(i, j));
					dfsQ.add(new Place(i, j));
				}
			}
		}
		int t = 0;
		int res = 0;
		while (!dfsQ.isEmpty()) {
			if (seperCheck(dfsQ)) {
				res = t;
				break;
			}
			t++;
			iceList = numDown(iceList);
		}
		System.out.print(res);
	}

	public static boolean seperCheck(ArrayDeque<Place> dfsQ) {
		int length = dfsQ.size();
		boolean[][] visited = new boolean[N][M];
		boolean flag = false;
		while (length-- > 0) {
			Place now = dfsQ.poll();
			if (board[now.x][now.y] > 0) {
				if (!visited[now.x][now.y]) {
					dfs(now.x, now.y, visited);
					if (flag) return true;
					flag = true;
				}
				dfsQ.add(new Place(now.x, now.y));
			}
		}
		return false;
	}
	
	public static void dfs(int x, int y, boolean[][] visited) {
		if (isOut(x, y) || board[x][y] == 0 || visited[x][y]) return;
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			dfs(nx, ny, visited);
		}
	}
	
	public static ArrayList<Place> numDown(ArrayList<Place> iceList) {
		iceDownCnt = new int[N][M];
		for (Place now : iceList) {
			int cnt = 0;
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (!isOut(nx, ny) && board[nx][ny] == 0) cnt++;
			}
			iceDownCnt[now.x][now.y] = Math.min(board[now.x][now.y], cnt);
		}
		ArrayList<Place> newList = new ArrayList<>();
		for (Place now : iceList) {
			if ((board[now.x][now.y] -= iceDownCnt[now.x][now.y]) > 0) newList.add(new Place(now.x, now.y));
		}
		return newList;
	}
	
	public static boolean isOut(int x, int y) {
		return x < 0 || x >= N || y < 0 || y >= M;
	}
}