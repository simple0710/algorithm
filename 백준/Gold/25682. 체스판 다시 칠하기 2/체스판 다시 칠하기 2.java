import java.io.*;

public class Main {
    static int N, M, K;
    static int[][] board;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);
        board = new int[N+1][M+1];
        boolean color = false;
        // 시작은 검은색
        for (int i = 1; i <= N; i++) {
            char[] charArr = br.readLine().toCharArray();
            for (int j = 1; j <= M; j++) {
                char now = charArr[j-1];
                if (!color && now == 'W') board[i][j] = 1;
                else if (color && now == 'B') board[i][j] = 1;
                color = !color;
                board[i][j] += board[i-1][j] + board[i][j-1] - board[i-1][j-1];
            }
            if (M % 2 == 0) color = !color;
        }
        int min = K*K;
        int max = 0;
        for (int i = K; i <= N; i++) {
            for (int j = K; j <= M; j++) {
                int v = board[i][j] - board[i-K][j] - board[i][j-K] + board[i-K][j-K];
                max = Math.max(max, v);
                min = Math.min(min, v);
            }
        }
        System.out.print(Math.min(K*K-max, min));
    }
}