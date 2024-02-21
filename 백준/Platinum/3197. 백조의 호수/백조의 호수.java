import java.io.*;
import java.util.*;

public class Main {
	public static class Place {
		int x;
		int y;
		Place(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static class vInfo {
		int dis;
		int color;
		vInfo(int dis, int color) {
			this.dis = dis;
			this.color = color;
		}
	}
	static int N, M, res;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static String[][] board;
	static Place end;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new String[N][M];
		ArrayDeque<Place> bq = new ArrayDeque<>(), q = new ArrayDeque<>();
		vInfo[][] visited1 = new vInfo[N][M];
		vInfo[][] visited2 = new vInfo[N][M];
		int idx = 1;
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				if (board[i][j].equals("L")) {
					board[i][j] = ".";
					bq.add(new Place(i, j));
					visited1[i][j] = new vInfo(0, idx++);
				}
				if (board[i][j].equals(".")) {
					visited2[i][j] = new vInfo(0, 1);
					q.add(new Place(i, j));
				}
			}
		}
		end = bq.poll();
		while (true) {
			bq = bfs(bq, visited1, false);
			q = bfs(q, visited2, true);
			if (res != 0) break;
		}
		System.out.print(res);
	}
	
	public static ArrayDeque<Place> bfs(ArrayDeque<Place> q, vInfo[][] visited, boolean flag) {
		ArrayDeque<Place> newQ = new ArrayDeque<>();
		int check = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			Place now = q.poll();
			if (!flag && now.x == end.x && now.y == end.y) res = visited[now.x][now.y].dis;
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < M) {
					if (visited[nx][ny] == null) {
						int nowDis = visited[now.x][now.y].dis; 
						if (board[nx][ny].equals("X")) {
							if (flag) board[nx][ny] = ".";
							newQ.add(new Place(nx, ny));
							nowDis++;
						} else q.add(new Place(nx, ny));
						visited[nx][ny] = new vInfo(nowDis, visited[now.x][now.y].color);
					} else if(visited[nx][ny].color != visited[now.x][now.y].color) {
						check = Math.min(check, Math.max(visited[nx][ny].dis, visited[now.x][now.y].dis));
					}
				}
			}
		}
		if (check != Integer.MAX_VALUE) res = check;
		return newQ;
	}
}