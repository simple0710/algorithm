import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int C = Integer.parseInt(input[2]);
        int D = Integer.parseInt(input[3]);

        int[][] dp = new int[N+1][C+1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= C; j++) {
                dp[i][j] = (i / C) * D;
            }
        }

        while (M-- > 0) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            int d = Integer.parseInt(input[3]);

            for (int i = N; i >= c; i--) {
                for (int j = C; j >= 0; j--) {
                    int maxCount = Math.min(a / b, i / c);
                    for (int k = 1; k <= maxCount; k++) {
                        if (i - k * c >= 0) {
                            dp[i][j] = Math.max(dp[i][j], dp[i - k * c][j] + k * d);
                        }
                    }
                }
            }
        }

        System.out.print(dp[N][C]);
    }
}