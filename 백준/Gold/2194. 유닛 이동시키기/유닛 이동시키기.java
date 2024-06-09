import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N, M, A, B;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static boolean[][] board;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        board = new boolean[N+1][M+1];
        A = Integer.parseInt(input[2]);
        B = Integer.parseInt(input[3]);
        int K = Integer.parseInt(input[4]);
        while (K-- > 0 ) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            board[x][y] = true;
        }
        input = br.readLine().split(" ");
        int sx = Integer.parseInt(input[0]);
        int sy = Integer.parseInt(input[1]);
        Point start = new Point(sx, sy);

        input = br.readLine().split(" ");
        int ex = Integer.parseInt(input[0]);
        int ey = Integer.parseInt(input[1]);
        Point end = new Point(ex, ey);
        System.out.print(bfs(start, end));
    }

    private static int bfs(Point start, Point end) {
        int[][] visited = new int[N+1][M+1];
        ArrayDeque<Point> q = new ArrayDeque<>();
        visited[start.x][start.y] = 1;
        q.add(start);
        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (!isOut(nx, ny) && !isOut(nx + A - 1, ny + B - 1) && visited[nx][ny] == 0) {
                    if (i < 2) {
                        if (canMoveB(nx, ny) && canMoveB(nx + A - 1, ny)) {
                            q.add(new Point(nx, ny));
                            visited[nx][ny] = visited[now.x][now.y] + 1;
                        }
                    }
                    else {
                        if (canMoveA(nx, ny) && canMoveA(nx, ny + B - 1)) {
                            q.add(new Point(nx, ny));
                            visited[nx][ny] = visited[now.x][now.y] + 1;
                        }
                    }
                }
            }
        }
        return visited[end.x][end.y] - 1;
    }

    private static boolean canMoveA(int x, int y) {
        for (int nx = x; nx < x + A; nx++) {
            if (isOut(nx, y) || board[nx][y]) return false;
        }
        return true;
    }

    private static boolean canMoveB(int x, int y) {
        for (int ny = y; ny < y + B; ny++) {
            if (isOut(x, ny) || board[x][ny]) return false;
        }
        return true;
    }

    private static boolean isOut(int x, int y) {
        return x < 1 || N + 1 <= x || y < 1 || M + 1 <= y;
    }
}