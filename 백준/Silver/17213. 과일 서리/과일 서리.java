import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][M + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = i; j <= M; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
            }
        }
        System.out.print(dp[N][M]);
    }
}