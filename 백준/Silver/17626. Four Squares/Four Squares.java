import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        dp[1] = 1;
        for (int i = 2 ; i <= N; i++) {
            int min = Integer.MAX_VALUE;
            int v = 1;
            while (v * v <= i) {
                min = Math.min(min, dp[i-(v*v)]);
                v++;
            }
            dp[i] = min + 1;
        }
        System.out.print(dp[N]);
    }
}