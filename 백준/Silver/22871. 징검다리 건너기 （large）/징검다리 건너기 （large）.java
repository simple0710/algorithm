import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        long[] dp = new long[N];
        long[] arr = new long[N];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
            for (int j = 0; j < i; j++) {
                long moveP = Math.max(dp[j], (i - j) * (1 + Math.abs(arr[i] - arr[j])));
                dp[i] = Math.min(dp[i], moveP);
            }
        }
        System.out.print(dp[N-1]);
    }
}