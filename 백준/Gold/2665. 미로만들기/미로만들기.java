import java.awt.*;
import java.io.*;
import java.util.*;

class Main {
    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static char[][] board;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        for (int i = 0; i < N; i++) board[i] = br.readLine().toCharArray();
        System.out.print(bfs());
    }

    private static int bfs() {
        ArrayDeque<Point> q = new ArrayDeque<>();
        int[][] visited = new int[N][N];
        q.add(new Point(0, 0));
        visited[0][0] = 1;
        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < N && visited[nx][ny] == 0) {
                    visited[nx][ny] = visited[now.x][now.y];
                    if (board[nx][ny] == '1') {
                        q.addFirst(new Point(nx, ny));
                    }
                    else {
                        q.add(new Point(nx, ny));
                        visited[nx][ny]++;
                    }
                }
            }
        }
        return visited[N-1][N-1] - 1;
    }
}