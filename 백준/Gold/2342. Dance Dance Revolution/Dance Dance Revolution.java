import java.io.*;

public class Main {
    static final int MAX = 400_000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = ("0 "+ br.readLine()).split(" ");
        int len = input.length-1;
        int[][][] dp = new int[len][5][5];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= 4; j++) {
                for (int k = 0; k <= 4; k++) {
                    dp[i][j][k] = MAX;
                }
            }
        }
        dp[0][0][0] = 0;
        for (int i = 1; i < len; i++) {
            int now = Integer.parseInt(input[i]);
            for (int j = 0; j <= 4; j++) {
                for (int k = 0; k <= 4; k++) {
                    dp[i][now][j] = Math.min(dp[i][now][j], dp[i-1][k][j] + getMove(k, now));
                    dp[i][j][now] = Math.min(dp[i][j][now], dp[i-1][j][k] + getMove(k, now));
                }
            }
        }
        int res = MAX;
        for (int i = 0; i <= 4; i++) {
            res = Math.min(res, dp[len-1][i][Integer.parseInt(input[len-1])]);
            res = Math.min(res, dp[len-1][Integer.parseInt(input[len-1])][i]);
        }
        System.out.print(res);
    }

    public static int getMove(int a, int b) {
        if (a == 0) return 2;
        else if (a == b) return 1;
        else if (Math.abs(a-b) == 2) return 4;
        else return 3;
    }
}