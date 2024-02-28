import java.io.*;
import java.util.*;

public class Main {
	static int N, startX, startY, size, eat;
	static int[] dx = {-1, 0, 0, 1}, dy = {0, -1, 1, 0};
	static int[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		for (int i = 0; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 9) {
					startX = i; startY = j;
					board[i][j] = 0;
				}
			}
		}
		int res = 0;
		int cnt;
		eat = 0;
		size = 2;
		while ((cnt = bfs()) > 0) res += cnt;
		System.out.print(res);
	}
	
	public static int bfs() {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		ArrayList<int[]> fishList = new ArrayList<>(); 
		q.add(new int[] {startX, startY});
		int[][] visited = new int[N][N];
		visited[startX][startY] = 1;
		int maxDistance = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			if (visited[now[0]][now[1]] > maxDistance) continue;
			if (0 < board[now[0]][now[1]] && board[now[0]][now[1]] < size) {
				fishList.add(now);
				maxDistance = visited[now[0]][now[1]];
				continue;
			}
			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < N && visited[nx][ny] == 0 && board[nx][ny] <= size) {
					q.add(new int[] {nx, ny});
					visited[nx][ny] = visited[now[0]][now[1]] + 1;
				}
			}
		}
		if (!fishList.isEmpty()) {
			Collections.sort(fishList, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
			int[] fish = fishList.get(0);
			board[fish[0]][fish[1]] = 0;
			startX = fish[0];
			startY = fish[1];
			if (++eat == size) {
				size++;
				eat = 0;
			}
			return visited[fish[0]][fish[1]] - 1;
		}
		return 0;
	}
}