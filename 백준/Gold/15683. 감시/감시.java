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
	static int N, M, res, totalEmptyPlaceCnt;
	static int[] dx = new int[] {-1, 0, 1, 0}, dy = new int[] {0, 1, 0, -1};
	static int[][] board;
	static ArrayList<Place> cctvList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		cctvList = new ArrayList<>();
		totalEmptyPlaceCnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 0) totalEmptyPlaceCnt++;
				else if (board[i][j] < 6) cctvList.add(new Place(i, j));
			}
		}
		res = totalEmptyPlaceCnt;
		back(0, 0);
		System.out.print(res);
	}
	public static void back(int depth, int fillPlaceCnt) {
		if (depth == cctvList.size()) {
			res = Math.min(res, totalEmptyPlaceCnt - fillPlaceCnt);
			return;
		}
		int x = cctvList.get(depth).x;
		int y = cctvList.get(depth).y;
		int[] canSeeArea = cctvType(board[x][y]);
		for (int i = 0; i < 4; i++) {
			int seeCnt = 0;
			for (int j = 0; j < canSeeArea.length; j++) seeCnt += fillSeeArea(canSeeArea[j], x, y);
			back(depth + 1, fillPlaceCnt + seeCnt);
			for (int j = 0; j < canSeeArea.length; j++) {
				eraseSeeArea(canSeeArea[j], x, y);
				canSeeArea[j] = (canSeeArea[j] + 1) % 4;
			}
		}
	}
	
	public static int[] cctvType(int number) {
		if (number == 1) return new int[] {0};
		else if (number == 2) return new int[] {0, 2};
		else if (number == 3) return new int[] {0, 1};
		else if (number == 4) return new int[] {0, 1, 2};
		return new int[] {0, 1, 2, 3};
	}
	
	public static int fillSeeArea(int d, int x, int y) {
		int cnt = 0;
		while (0 <= x && x < N && 0 <= y && y < M && board[x][y] < 6) {
			if (board[x][y] <= 0) {
				if (board[x][y] == 0) cnt++;
				board[x][y]--;
			}
			x += dx[d];
			y += dy[d];
		}
		return cnt;
	}
	
	public static void eraseSeeArea(int d, int x, int y) {
		while (0 <= x && x < N && 0 <= y && y < M && board[x][y] < 6) {
			if (board[x][y] < 0) {
				board[x][y]++;
			}
			x += dx[d];
			y += dy[d];
		}
	}
}