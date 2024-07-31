import java.io.*;

public class Main {
    static int M, N;
    static int[][] board, dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        board = new int[M][N];
        for (int i = 0; i < M; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }
        dp = new int[M][N];
        int res = 0;
        for (int i = 0; i < M; i++) res = Math.max(res, getRes(i, N-1) - board[i][N-1]);
        System.out.print(res);
    }

    private static int getRes(int x, int y) {
        if (x < 0 || x >= M || y < 0) return 0;
        if (dp[x][y] == 0) {
            dp[x][y] = board[x][y];
            for (int i = -1; i < 2; i++) {
                dp[x][y] = Math.max(dp[x][y], getRes(x-i, y-1) + board[x][y]);
            }
        }
        return dp[x][y];
    }
}