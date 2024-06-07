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
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int R1 = Integer.parseInt(input[0]);
        int C1 = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        int R2 = Integer.parseInt(input[0]);
        int C2 = Integer.parseInt(input[1]);
        System.out.print(bfs(R1, C1, R2, C2));
    }

    private static int bfs(int r1, int c1, int r2, int c2) {
        int[][] visited = new int[10][9];
        ArrayDeque<Point> q = new ArrayDeque<>();
        q.add(new Point(r1, c1));
        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (!isOut(nx, ny) && (nx != r2 || ny != c2)) {
                    for (int j: new int[] {-1, 1}) {
                        int mx = nx + dx[i] * 2;
                        int my = ny + dy[i] * 2;
                        int blockX = nx + dx[i];
                        int blockY = ny + dy[i];
                        if (i < 2) {
                            my += j * 2;
                            blockY += j;
                        }
                        else {
                            mx += j * 2;
                            blockX += j;
                        }
                        if (!isOut(mx, my) && (blockX != r2 || blockY != c2) && visited[mx][my] == 0){
                            q.add(new Point(mx, my));
                            visited[mx][my] = visited[now.x][now.y] + 1;
                        }
                    }
                }
            }
        }
        return visited[r2][c2] == 0 ? -1 : visited[r2][c2];
    }

    private static boolean isOut(int x, int y) {
        return x < 0 || 10 <= x || y < 0 || 9 <= y;
    }
}