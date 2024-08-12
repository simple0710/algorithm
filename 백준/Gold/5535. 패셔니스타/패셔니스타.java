import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int D = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        int[] maxTemp = new int[D];
        int[][] score = new int[D][2];
        for (int i = 0; i < D; i++) {
            int T = Integer.parseInt(br.readLine());
            maxTemp[i] = T;
            score[i][0] = 100;
        }
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            int C = Integer.parseInt(input[2]);
            for (int j = 0; j < D; j++) {
                if (A <= maxTemp[j] && maxTemp[j] <= B) {
                    score[j][0] = Math.min(score[j][0], C);
                    score[j][1] = Math.max(score[j][1], C);
                }
            }
        }
        int[][] dp = new int[D][2];
        for (int i = 1; i < D; i++) {
            dp[i][0] = Math.max(dp[i-1][0] + Math.abs(score[i][0] - score[i-1][0]), dp[i-1][1] + Math.abs(score[i][0] - score[i-1][1]));
            dp[i][1] = Math.max(dp[i-1][0] + Math.abs(score[i][1] - score[i-1][0]), dp[i-1][1] + Math.abs(score[i][1] - score[i-1][1]));
        }
        System.out.print(Math.max(dp[D-1][0], dp[D-1][1]));
    }
}