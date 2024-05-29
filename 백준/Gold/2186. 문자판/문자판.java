import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static char[][] arr;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static String word;
    static int[][][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);
        arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        word = br.readLine();
        dp = new int[word.length()][N][M];
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                res += dfs(0, i, j);
            }
        }
        System.out.print(res);
    }

    public static int dfs(int depth, int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M || word.charAt(depth) != arr[x][y]) return 0;
        if (word.length() - 1 == depth) return dp[depth][x][y] = 1;
        if (dp[depth][x][y] == -1) {
            dp[depth][x][y] = 0;
            for (int k = 1; k <= K; k++) {
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i] * k ;
                    int ny = y + dy[i] * k;
                    dp[depth][x][y] += dfs(depth + 1, nx, ny);
                }
            }
        }
        return dp[depth][x][y];
    }
}