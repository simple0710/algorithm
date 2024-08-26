import java.io.*;

public class Main {
    static final int MOD = 100_000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int w = Integer.parseInt(input[0]);
        int h = Integer.parseInt(input[1]);
        int[][][] dp = new int[2][w + 2][h + 2];
        dp[0][2][2] = dp[1][2][2] = 1;
        for (int i = 2; i < w + 2; i++) {
            for (int j = 2; j < h + 2; j++) {
                dp[0][i][j] += dp[0][i][j-1] + dp[1][i-1][j-1] % MOD;
                dp[1][i][j] += dp[1][i-1][j] + dp[0][i-1][j-1] % MOD;
            }
        }
        System.out.print((dp[0][w+1][h+1] + dp[1][w+1][h+1]) % MOD);
    }
}