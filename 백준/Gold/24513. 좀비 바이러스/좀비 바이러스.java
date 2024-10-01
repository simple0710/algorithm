import java.io.*;
import java.util.*;

public class Main {
    static class Place {
        int x;
        int y;
        Place(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N, M;
    static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
    static int[][] board, visitedTime;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        board = new int[N][M];
        visitedTime = new int[N][M];
        ArrayDeque<Place> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(input[j]);
                if (board[i][j] == 1 || board[i][j] == 2) {
                    q.add(new Place(i, j));
                    visitedTime[i][j] = 1;
                }
            }
        }
        bfs(q);

        int[] resArr = new int[4];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] != -1) resArr[board[i][j]]++;
            }
        }
        for (int i = 1; i < 4; i++) System.out.print(resArr[i] + " ");
    }

    private static void bfs(ArrayDeque<Place> q) {
        while (!q.isEmpty()) {
            Place now = q.poll();
            if (board[now.x][now.y] == 3) continue;
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (board[nx][ny] == -1 || board[nx][ny] == 3) continue;
                    if (board[nx][ny] == 0) {
                        board[nx][ny] = board[now.x][now.y];
                        visitedTime[nx][ny] = visitedTime[now.x][now.y] + 1;
                        q.add(new Place(nx, ny));
                    } else if (board[nx][ny] != board[now.x][now.y] && visitedTime[nx][ny] == visitedTime[now.x][now.y] + 1) {
                        board[nx][ny] = 3;
                    }
                }
            }
        }
    }
}