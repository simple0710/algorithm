import java.io.*;

public class Main {
	static int N;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static char[][] rgbBoard, rbBoard;
	static boolean[][][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		rgbBoard = new char[N][N];
		rbBoard = new char[N][N];
		for (int i = 0; i < N; i++) {
			char[] charArr = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				rgbBoard[i][j] = charArr[j];
				rbBoard[i][j] = charArr[j] == 'B' ? 'B' : 'R';
			}
		}
		int[] resArr = new int[2];
		visited = new boolean[2][N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < 2; k++) {
					if (!visited[k][i][j]) {
						dfs(k == 0 ? rgbBoard : rbBoard, k, i, j);
						resArr[k]++;
					}
				}
			}
		}
		System.out.print(resArr[0] + " " + resArr[1]);
	}
	public static void dfs(char[][] board, int w, int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < N && 0 <= ny && ny < N && !visited[w][nx][ny] && board[x][y] == board[nx][ny]) {
				visited[w][nx][ny] = true;
				dfs(board, w, nx, ny);
			}
		}
	}
}