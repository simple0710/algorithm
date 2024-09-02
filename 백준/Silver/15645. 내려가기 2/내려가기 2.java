import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][][] dp = new int[2][N+1][3];
        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                int now = Integer.parseInt(input[j]);
                dp[0][i][j] = dp[0][i-1][j];
                dp[1][i][j] = dp[1][i-1][j];
                if (0 <= j - 1) {
                    dp[0][i][j] = Math.min(dp[0][i][j], dp[0][i-1][j-1]);
                    dp[1][i][j] = Math.max(dp[1][i][j], dp[1][i-1][j-1]);
                }
                if (j + 1 < 3) {
                    dp[0][i][j] = Math.min(dp[0][i][j], dp[0][i-1][j+1]);
                    dp[1][i][j] = Math.max(dp[1][i][j], dp[1][i-1][j+1]);
                }
                dp[0][i][j] += now;
                dp[1][i][j] += now;
            }

        }
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, dp[0][N][i]);
            max = Math.max(max, dp[1][N][i]);
        }
        System.out.print(max + " " + min);
    }
}