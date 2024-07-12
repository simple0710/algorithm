import java.io.*;
import java.util.*;

public class Main {
    static class Bomb {
        int x;
        int y;
        int time;
        Bomb(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    static int R, C, N, time;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int[][] timeBoard;
    static char[][] board;
    static ArrayDeque<Bomb> bombQ;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input;
        input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        N = Integer.parseInt(input[2]);
        board = new char[R][C];
        timeBoard = new int[R][C];
        bombQ = new ArrayDeque<>();
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (board[i][j] == 'O') {
                    bombQ.add(new Bomb(i, j, 0));
                }
            }
        }
        time = 1;
        while (++time <= N) {
            putBomb();
            if (++time > N) break;
            fireBomb();
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) sb.append(board[i][j]);
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void putBomb() {
        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {
                if (board[x][y] == '.') {
                    bombQ.add(new Bomb(x, y, time));
                    timeBoard[x][y] = time;
                    board[x][y] = 'O';
                }
            }
        }
    }

    private static void fireBomb() {
        while (!bombQ.isEmpty() && time - 3 >= bombQ.getFirst().time) {
            Bomb now = bombQ.poll();
            if (now.time == timeBoard[now.x][now.y] && time - 3 == now.time && board[now.x][now.y] == 'O') {
                board[now.x][now.y] = '.';
                for (int d = 0; d < 4; d++) {
                    int nx = now.x + dx[d];
                    int ny = now.y + dy[d];
                    if (0 <= nx && nx < R && 0 <= ny && ny < C && timeBoard[nx][ny] != now.time) board[nx][ny] = '.';
                }
            }
        }
    }
}