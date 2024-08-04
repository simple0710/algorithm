import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N+1][M+1];
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a < b) {
                graph.get(b).add(new Pair(a, c));
            }
        }

        for (int i = 2; i <= N; i++) {
            for (Pair p : graph.get(i)) {
                int prev = p.first;
                int score = p.second;
                for (int j = 2; j <= M; j++) {
                    if (dp[prev][j-1] > 0 || prev == 1) {
                        dp[i][j] = Math.max(dp[i][j], dp[prev][j-1] + score);
                    }
                }
            }
        }

        int result = 0;
        for (int i = 2; i <= M; i++) {
            result = Math.max(result, dp[N][i]);
        }

        System.out.println(result);
    }

    static class Pair {
        int first, second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}