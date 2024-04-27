import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String[] str = br.readLine().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = (int) (Double.parseDouble(str[1]) * 100 + 0.5);
            if (N == 0) break;
            int[] dp = new int[M+1];
            while (N-- > 0) {
                str = br.readLine().split(" ");
                int C = Integer.parseInt(str[0]);
                int P = (int) (Double.parseDouble(str[1]) * 100 + 0.5);
                for (int i = P; i <= M; i++) {
                    dp[i] = Math.max(dp[i], dp[i-P] + C);
                }
            }
            sb.append(dp[M]).append("\n");
        }
        System.out.print(sb);
    }
}