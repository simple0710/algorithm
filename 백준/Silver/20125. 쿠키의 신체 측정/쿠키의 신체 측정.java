import java.io.*;

public class Main {
    static int N;
    static int[] dx = {0, 0, 1, 1}, dy = {-1, 1, -1, 1}, vx = {0, 0, 1, 1}, vy = {-1, 1, 0, 0};
    static char[][] board;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        int[] heart = new int[3];
        int[] body = new int[2];
        int cnt = 0;
        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (board[i][j] == '*' && !isOut(i-1, j)) {
                    if (heart[2] == 0) heart = new int[] {i, j, 1};
                    if (heart[1] == j) body = new int[] {i, j};
                }
            }
        }
        sb.append(heart[0] + 1).append(" ").append(heart[1] + 1).append("\n");
        int[][] check = new int[][] {heart, body};
        for (int i = 0; i < 4; i++) {
            if (i == 2) sb.append(body[0] - heart[0]).append(" ");
            sb.append(getLength(check[i/2][0] + dx[i], check[i/2][1] + dy[i], vx[i], vy[i])).append(" ");
        }
        System.out.print(sb);
    }

    private static boolean isOut(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= N || board[x][y] == '_';
    }

    private static int getLength(int startX, int startY, int vx, int vy) {
        int cnt = 1;
        while (!isOut(startX += vx, startY += vy)) cnt++;
        return cnt;
    }
}