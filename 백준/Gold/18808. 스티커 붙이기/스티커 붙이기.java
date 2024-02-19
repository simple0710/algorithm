import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int[][] nowSticker = new int[R][C];
			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < C; j++) nowSticker[i][j] = Integer.parseInt(st.nextToken());
			}
			for (int s = 0; s < 4; s++) {
				if (isStickerIn(nowSticker, R, C)) break;
				nowSticker = spin(nowSticker, R, C);
				int temp = C;
				C = R; R = temp;
			}
		}
		int res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 1) res++;
			}
		}
		System.out.print(res);
	}
	
	public static boolean isStickerIn(int[][] sticker, int R, int C) {
		for (int i = 0; i <= N - R; i++) {
			for (int j = 0; j <= M - C; j++) {
				if (stickerTest(sticker, i, j, R, C)) {
					inSticker(sticker, i, j, R, C);
					return true;
				};
			}
		}
		return false;
	}
	
	public static boolean stickerTest(int[][] sticker, int nowX, int nowY, int R, int C) {
		for (int i = nowX; i < nowX + R; i++) {
			for (int j = nowY; j < nowY + C; j++) {
				if (sticker[i-nowX][j-nowY] == 1 && board[i][j] == 1) return false;
			}
		}
		return true;
	}
	
	public static int[][] spin(int[][] sticker, int R, int C) {
		int[][] newSticker = new int[C][R];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				newSticker[j][i] = sticker[R-1-i][j];
			}
		}
		return newSticker;
	}
	
	public static void inSticker(int[][] sticker, int ni, int nj, int R, int C) {
		for (int i = ni; i < ni + R; i++) {
			for (int j = nj; j < nj + C; j++) {
				if (sticker[i-ni][j-nj] == 1) board[i][j] = sticker[i-ni][j-nj];
			}
		}
	}
}