import java.io.*;
import java.util.*;

class Main {
    static class Place {
        int x;
        int y;
        Place(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N, M, X;
    static boolean[][] board;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        board = new boolean[N][M];
        for (int i = 0; i < N ;i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(input[j]) == 1;
            }
        }
        X = Integer.parseInt(br.readLine());
        System.out.print(bfs());
    }



    private static String bfs() {
        ArrayDeque<Place> q = new ArrayDeque<>();
        q.add(new Place(0, 0));
        boolean[][] visited = new boolean[N][M];
        while (!q.isEmpty()) {
            Place now = q.poll();
            int xs = Math.max(0, now.x - X);
            int xe = Math.min(N - 1, now.x + X);
            for (int x = xs; x <= xe; x++) {
                int yRange = X - Math.abs(now.x - x);
                int ys = Math.max(0, now.y - yRange);
                int ye = Math.min(M - 1, now.y + yRange);
                for (int y = ys; y <= ye; y++) {
                    if (!visited[x][y] && board[now.x][now.y] == board[x][y]) {
                        q.add(new Place(x, y));
                        visited[x][y] = true;
                    }
                }
            }
        }
        return visited[N-1][M-1] ? "ALIVE" : "DEAD";
    }

    private static boolean isOut(int x, int y) {
        return true;
    }
}