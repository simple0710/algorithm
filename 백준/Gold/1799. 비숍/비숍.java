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
	static int N, blackRes, whiteRes;
	static int[] dx = new int[] {-1, -1, 1, 1}, dy = new int[] {-1, 1, -1, 1};
	static int[][] board;
	static boolean[][] chessBoard;
	static ArrayList<Place> whitePlace, blackPlace;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		whitePlace = new ArrayList<>();
		blackPlace = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1) {
					if ((i + j) % 2 == 0) blackPlace.add(new Place(i, j));
					else whitePlace.add(new Place(i, j));
				}
			}
		}
		blackRes = 0;
		whiteRes = 0;
		chessBoard = new boolean[N][N];
		back(blackPlace, 0, 0, false);
		back(whitePlace, 0, 0, true);
		System.out.print(blackRes + whiteRes);
	}
	
	public static void back(ArrayList<Place> chessPlace, int depth, int cnt, boolean flag) {
		if (depth == chessPlace.size()) {
			if (flag) whiteRes = Math.max(whiteRes, cnt);
			else blackRes = Math.max(blackRes, cnt);
			return;
		}
		Place now = chessPlace.get(depth);
		if (isAble(now.x, now.y)) {
			chessBoard[now.x][now.y] = true;
			back(chessPlace, depth + 1, cnt + 1, flag);
			chessBoard[now.x][now.y] = false;
		}
		back(chessPlace, depth + 1, cnt, flag);
	}
	
	public static boolean isAble(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			while (0 <= nx && nx < N && 0 <= ny && ny < N) {
				if (chessBoard[nx][ny]) return false;
				nx += dx[i];
				ny += dy[i];
			}
		}
		return true;
	}
}