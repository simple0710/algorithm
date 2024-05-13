import java.io.*;
import java.util.*;

public class Main {
	static final int INF = Integer.MAX_VALUE;
	static class Data {
		int x;
		int y;
		int h;
		Data(int x, int y, int h) {
			this.x = x;
			this.y = y;
			this.h = h;
		}
	}
	static int N;
	static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
	static int[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) arr[i][j] = Integer.parseInt(input[j]);
		}
		System.out.print(dijkstra());
	}
	
	private static <T> int dijkstra() {
		PriorityQueue<Data> pq = new PriorityQueue<>(new Comparator<Data>() {
			@Override
			public int compare(Data o1, Data o2) {
				return o1.h-o2.h;
			}
		} );
		int[][] visited = new int[N][N];
		for (int i = 0; i < N; i++) Arrays.fill(visited[i], INF);
		visited[0][0] = 0;
		pq.add(new Data(0, 0, 0));
		while (!pq.isEmpty()) {
			Data now = pq.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (!isOut(nx, ny)) {
					int g = Math.abs(arr[now.x][now.y] - arr[nx][ny]);
					int nowG = Math.max(now.h, g);
					if (visited[nx][ny] > nowG) {
						pq.add(new Data(nx, ny, nowG));
						visited[nx][ny] = nowG;
					}
				}
			}
		}
		return visited[N-1][N-1];
	}

	private static boolean isOut(int x, int y) {
		return x < 0 || x >= N || y < 0 || y >= N;
	}
}