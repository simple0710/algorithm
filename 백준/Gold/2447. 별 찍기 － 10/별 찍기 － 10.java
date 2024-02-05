import java.io.*;

public class Main {
	static int N;
	static int[] dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1}, dy = new int[]{-1, 0, 1, -1, 1, -1, 0, 1}; 
	static String[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new String[N][N];
		recur(N/3, N/2, N/2);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(board[i][j] == null ? " " : "*");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	public static void recur(int nowN, int centerX, int centerY) {
		if (nowN == 1) {
			for (int i = 0 ; i < 8; i++) board[centerX + dx[i]][centerY + dy[i]] = "*";
			return;
		}
		for (int i = 0 ; i < 8; i++) recur(nowN/3, centerX + nowN * dx[i], centerY + nowN * dy[i]);
	}
}