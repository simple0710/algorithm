import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        String[] input = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(input[i-1]);
        int[][] dp = new int[N+1][N+1];
        for (int i = 0; i < N; i++) {
            for (int s = 1; s < N+1-i; s++) {
                int e = s + i;
                if (s == e || (arr[s] == arr[e] && (dp[s+1][e-1] == 1 || s + 1 == e))) dp[s][e] = 1;
            }
        }
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            sb.append(dp[s][e]).append("\n");
        }
        System.out.print(sb);
    }
}