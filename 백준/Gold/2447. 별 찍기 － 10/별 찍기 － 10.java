import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0}, dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    static String[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new String[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(board[i], "*");
        }
        recursion(N / 3, N / 2, N / 2);
        for (int i = 0; i < N; i++) {
            System.out.println(String.join("", board[i]));
        }
    }

    public static void recursion(int n, int x, int y) {
        if (n == 1) {
            board[x][y] = " ";
            return;
        }
        for (int i = x - n/2; i <= x+n/2; i++) {
            for (int j = y - n/2; j <= y+n/2; j++) {
                board[i][j] = " ";
            }
        }
        for (int i = 0; i < 8; i++) {
            recursion(n/3, x+n*dx[i], y+n*dy[i]);
        }
    }
}