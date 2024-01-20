import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[][] board = new int[10][10];
	static boolean[][] visited = new boolean[10][10];
	static int res = 26;
	static ArrayList<Place> list = new ArrayList<>();
	static int[] paperType = { 5, 5, 5, 5, 5 };

	static class Place {
		int x;
		int y;

		Place(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1)
					list.add(new Place(i, j));
			}
		}
		back(0, 0);
		System.out.print(res == 26 ? -1 : res);
	}

	public static void back(int depth, int total) {
		if (total >= res) return;
		if (depth == list.size()) {
			res = Math.min(res, total);
			return;
		}
		int x = list.get(depth).x;
		int y = list.get(depth).y;

		if (visited[x][y]) {
			back(depth + 1, total);
			return;
		}
		int maxLength = Math.min(Math.min(10, x + 5) - x, Math.min(10, y + 5) - y);
		for (int i = 0; i < maxLength; i++) {
			for (int j = 0; j < maxLength; j++) {
				if (i == 0 && j == 0)
					continue;
				if (board[x + i][y + j] == 0 || visited[x + i][y + j]) {
					maxLength = Math.min(maxLength, j);
				}
				if (board[x + j][y + i] == 0 || visited[x + j][y + i]) {
					maxLength = Math.min(maxLength, j);
				}
			}
		}
		for (int i = 0; i < maxLength; i++) {
			for (int j = 0; j < maxLength; j++) {
				visited[x + i][y + j] = true;
			}
		}
		for (int t = maxLength - 1; t >= 0; t--) {
			if (paperType[t] != 0) {
				paperType[t]--;
				back(depth + 1, total + 1);
				paperType[t]++;
			}
			for (int i = 0; i < t + 1; i++) {
				visited[x + t][y + i] = false;
				visited[x + i][y + t] = false;
			}
		}
	}
}