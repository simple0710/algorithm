import java.io.*;
import java.util.*;

class Main {
    static final int N = 5;
    static int res;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static boolean[][] checkArr;
    static char[][] board;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new char[N][N];
        checkArr = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }
        res = 0;
        back(0, 0, 0);
        System.out.print(res);
    }

    private static void back(int depth, int now, int yCnt) {
        if (yCnt >= 4) return;
        if (depth == 7) {
            int x = now / N;
            int y = now % N;
            res += bfs(x, y);
            return;
        }
        for (int i = now; i < N * N; i++) {
            int x = i / N;
            int y = i % N;
            if (!checkArr[x][y]) {
                checkArr[x][y] = true;
                back(depth + 1, i, yCnt + (board[x][y] == 'Y' ? 1 : 0));
                checkArr[x][y] = false;
            }
        }
    }

    private static int bfs(int x, int y) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});
        boolean[][] visited = new boolean[N][N];
        visited[x][y] = true;
        int cnt = 1;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny] && checkArr[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[] {nx, ny});
                    cnt++;
                }
            }
        }
        return cnt == 7 ? 1 : 0;
    }
}