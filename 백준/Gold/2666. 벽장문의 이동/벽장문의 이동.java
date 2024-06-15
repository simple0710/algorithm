import java.io.*;

public class Main {
    static int M;
    static int[] arr;
    static int[][][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        M = Integer.parseInt(br.readLine());
        dp = new int[M+1][N+1][N+1];
        arr = new int[M+1];
        for (int i = 0; i < M; i++) arr[i] = Integer.parseInt(br.readLine());
        System.out.print(dfs(0, a, b));
    }

    private static int dfs(int idx, int left, int right) {
        if (idx == M) return 0;
        if (dp[idx][left][right] != -1) {
            int leftMove = Math.abs(left - arr[idx]) + dfs(idx + 1, arr[idx], right);
            int rightMove = Math.abs(right - arr[idx]) + dfs(idx + 1, left, arr[idx]);
            dp[idx][left][right] = Math.min(leftMove, rightMove);
        }
        return dp[idx][left][right];
    }
}
