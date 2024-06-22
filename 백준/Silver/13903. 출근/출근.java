import java.io.*;
import java.util.*;

public class Main {
    static class Place {
        int x;
        int y;
        Place (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int R, C, N;
    static int[] dx, dy;
    static boolean[][] board;
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        board = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < C; j++) board[i][j] = input[j].equals("1");
        }
        N = Integer.parseInt(br.readLine());
        dx = new int[N];
        dy = new int[N];
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            dx[i] = Integer.parseInt(input[0]);
            dy[i] = Integer.parseInt(input[1]);
        }
        System.out.print(bfs());
    }

    private static int bfs() {
        ArrayDeque<Place> q = new ArrayDeque<>();
        int[][] visited = new int[R][C];
        for (int i = 0; i < C; i++) {
            visited[0][i] = 1;
            if (board[0][i]) q.add(new Place(0, i));
        }
        while (!q.isEmpty()) {
            Place now = q.poll();
            for (int i = 0; i < N; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (0 <= nx && nx < R && 0 <= ny && ny < C && (visited[nx][ny] == 0 || visited[nx][ny] > visited[now.x][now.y] + 1) && board[nx][ny]) {
                    q.add(new Place(nx, ny));
                    visited[nx][ny] = visited[now.x][now.y] + 1;
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < C; i++) {
            if (visited[R-1][i] != 0) res = Math.min(res, visited[R-1][i]);
        }
        return res == Integer.MAX_VALUE ? -1 : res - 1;
    }
}