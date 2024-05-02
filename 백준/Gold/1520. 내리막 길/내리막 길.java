import java.io.*;

public class Main {
    static int M, N;
    static int[] dx = new int[] {-1, 1, 0, 0}, dy = new int[]{0, 0, -1, 1};
    static int[][] arr, dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        arr = new int[M][N];
        dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
                dp[i][j] = -1;
            }
        }
        dp[0][0] = 1;
        System.out.print(getValue(M-1, N-1));
    }

    private static int getValue(int m, int n) {
        if (dp[m][n] == -1) {
            dp[m][n] = 0;
            for (int i = 0; i < 4; i++) {
                int mx = m + dx[i];
                int ny = n + dy[i];
                if (!isOut(mx, ny) && arr[m][n] < arr[mx][ny]) {
                    dp[m][n] += getValue(m+dx[i], n+dy[i]);
                }
            }
        }
        return dp[m][n];
    }

    private static boolean isOut(int x, int y) {
        return 0 > x || x >= M || 0 > y || y >= N;
    }
}