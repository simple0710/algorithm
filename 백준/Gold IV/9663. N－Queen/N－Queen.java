import java.io.*;
import java.util.*;

public class Main {
	static final int[] dx = new int[] { -1, -1, -1, 0, 1, 1, 1, 0 }, dy = new int[] { -1, 0, 1, 1, 1, 0, -1, -1 };
	static int N, res;
	static boolean[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		board = new boolean[N][N];
		res = 0;
		back(0, 0);
		System.out.print(res);
	}

	public static void back(int depth, int cnt) {
		if (cnt == N) {
			res++;
			return;
		}
		if (depth >= N) return;
		for (int i = 0; i < N; i++) {
			if (isAble(depth, i)) {
				board[depth][i] = true;
				back(depth + 1, cnt + 1);
				board[depth][i] = false;
			}
		}
	}

	public static boolean isAble(int x, int y) {
		for (int d = 0; d < 8; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			while (0 <= nx && nx < N && 0 <= ny && ny < N) {
				if (board[nx][ny]) return false;
				nx += dx[d];
				ny += dy[d];
			}
		}
		return true;
	}
}