import java.io.*;

public class Main {
    static int N, K;
    static int[] small, big;
    static int[][] dp;
    static String[] input;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        small = new int[N];
        big = new int[N];
        dp = new int[2][N+1];
        for (int i = 0; i < N-1; i++) {
            input = br.readLine().split(" ");
            small[i] = Integer.parseInt(input[0]);
            big[i] = Integer.parseInt(input[1]);
        }
        K = Integer.parseInt(br.readLine());
        dp[0][1] = dp[1][1] = small[0];
        for (int i = 2; i < N; i++) {
            dp[0][i] = Math.min(dp[0][i-1] + small[i-1], dp[0][i-2] + big[i-2]);
            dp[1][i] = Math.min(dp[1][i-1] + small[i-1], dp[1][i-2] + big[i-2]);
            if (i >= 3) dp[1][i] = Math.min(dp[1][i], dp[0][i-3] + K);
        }
        System.out.print(Math.min(dp[0][N-1], dp[1][N-1]));
    }
}