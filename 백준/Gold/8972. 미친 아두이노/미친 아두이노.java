import java.io.*;
import java.util.*;

public class Main {
    static class Place {
        int x;
        int y;
        boolean status;
        Place(int x, int y, boolean status) {
            this.x = x;
            this.y = y;
            this.status = status;
        }
    }
    static int R, C;
    static char[][] board;
    static int[] dx = {1, 1, 1, 0, 0, 0, -1, -1, -1}, dy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        board = new char[R][];
        Place nowI = new Place(0, 0, true);
        ArrayList<Place> crazy = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (board[i][j] == 'I') nowI = new Place(i, j, true);
                else if (board[i][j] == 'R') crazy.add(new Place(i, j, true));
            }
        }
        input = br.readLine().split("");
        boolean flag = true;
        int turn = 0;
        for (int i = 0; i < input.length; i++) {
            if (turn > 0) break;
            int[][] cntBoard = new int[R][C];
            int now = Integer.parseInt(input[i]) - 1;

            board[nowI.x][nowI.y] = '.';
            int nx = nowI.x + dx[now];
            int ny = nowI.y + dy[now];

            if (board[nx][ny] == 'R') {
                flag = false;
                turn = i + 1;
            }
            nowI = new Place(nx, ny, true);
            board[nx][ny] = 'I';

            for (Place ob : crazy) {
                if (ob.status) {
                    board[ob.x][ob.y] = '.';
                    int move = 0;
                    int distance = Integer.MAX_VALUE;
                    for (int d = 0; d < 9; d++) {
                        int nowDistance = getDistacne(nx, ny, ob.x + dx[d], ob.y + dy[d]);
                        if (nowDistance < distance) {
                            move = d;
                            distance = nowDistance;
                        }
                    }
                    ob.x += dx[move];
                    ob.y += dy[move];
                    if (board[ob.x][ob.y] == 'I') {
                        flag = false;
                        turn = i + 1;
                    }
                    board[ob.x][ob.y] = 'R';
                    cntBoard[ob.x][ob.y]++;
                }
            }

            for (Place ob : crazy) {
                if (ob.status) {
                    if (cntBoard[ob.x][ob.y] > 1) {
                        board[ob.x][ob.y] = '.';
                        ob.status = false;
                    } else board[ob.x][ob.y] = 'R';
                }
            }
        }
        if (flag) {
            for (char[] row : board) {
                for (char c : row) System.out.print(c);
                System.out.println();
            };
        } else System.out.println("kraj " + turn);
    }

    private static int getDistacne(int nx, int ny, int x, int y) {
        return Math.abs(nx - x) + Math.abs(ny - y);
    }
}