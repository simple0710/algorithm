import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] dp = new int[101];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for (int d = -99; d <= 99; d++) {
            Arrays.fill(dp, 0);
            for (int i = 0; i < N; i++) {
                if (A[i] - d < 1 || A[i] - d > 100) {
                    dp[A[i]] = 1;
                } else {
                    dp[A[i]] = dp[A[i] - d] + 1;
                }
                ans = Math.max(ans, dp[A[i]]);
            }
        }

        System.out.println(ans);
    }
}
