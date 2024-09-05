import java.io.*;

class Main {
    static long[] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new long[N+1];
        dp[0] = 1;
        System.out.print(getDp(N));
    }

    private static long getDp(int n) {
        if (dp[n] == 0) {
            for (int i = 0; i < n; i++) {
                dp[n] += getDp(n-1-i) * getDp(i);
            }
        }
        return dp[n];
    }
}