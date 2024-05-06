import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);
        int[][] dp = new int[M+1][K+1];
        while (N-- > 0) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            for (int i = M ; i >= x; i--) {
                for (int j = K; j >= y; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-x][j-y] + 1);
                }
            }
        }
        System.out.print(dp[M][K]);
    }
}