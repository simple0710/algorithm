import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int T = Integer.parseInt(input[1]);
        int[] dp = new int[T+1];
        int total = 0;
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            int d = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            total += m;
            for (int j = T; j >= d; j--) {
                dp[j] = Math.max(dp[j], dp[j-d] + m);
            }
        }
        System.out.print(total - dp[T]);
    }
}