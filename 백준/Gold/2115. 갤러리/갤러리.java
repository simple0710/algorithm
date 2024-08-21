import java.io.*;

public class Main {
    static int M, N;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static char[][] board;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        board = new char[M][];
        for (int i = 0; i < M; i++) {
            board[i] = br.readLine().toCharArray();
        }
        int res = 0;
        for (int i = 0; i < Math.max(M, N); i++) {
            res += checkLine(i);
        }
        System.out.print(res);
    }

    private static int checkLine(int now) {
        int cnt = 0;
        // 열 확인
        if (now < M) {
            int up = 0, down = 0;
            for (int i = 0; i < N; i++) {
                if (board[now][i] == '.') {
                    if (0 <= now - 1) {
                        if (board[now-1][i] == 'X') up++;
                        else {
                            cnt += up / 2;
                            up = 0;
                        }
                    }
                    if (now + 1 < M) {
                        if (board[now+1][i] == 'X') down++;
                        else {
                            cnt += down / 2;
                            down = 0;
                        }
                    }
                }
                if (board[now][i] == 'X') {
                    cnt += up / 2 + down / 2;
                    up = 0;
                    down = 0;
                }
            }
        }
        if (now < N) {
            int left = 0, right = 0;
            for (int i = 0; i < M; i++) {
                if (board[i][now] == '.') {
                    if (0 <= now - 1){
                        if (board[i][now-1] == 'X') left++;
                        else {
                            cnt += left / 2;
                            left = 0;
                        }
                    }
                    if (now + 1 < N) {
                        if (board[i][now + 1] == 'X') right++;
                        else {
                            cnt += right / 2;
                            right = 0;
                        }
                    }
                }
                if (board[i][now] == 'X') {
                    cnt += left / 2 + right / 2;
                    left = 0;
                    right = 0;
                }
            }
        }
        return cnt;
    }
}