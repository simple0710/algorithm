import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static class Empty {
        int x;
        int y;
        public Empty(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static ArrayList<Empty> arr;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new ArrayList<>();
        board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 0) arr.add(new Empty(i, j));
            }
        }
        back(0);
    }
    public static void back(int depth) {
        if (depth == arr.size()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.print(sb);
            System.exit(0);
        }
        for (int i = 1; i < 10; i++) {
            Empty now = arr.get(depth);
            if (checkColRow(now.x, now.y, i) && checkSquare(now.x, now.y, i)) {
                board[now.x][now.y] = i;
                back(depth+1);
                board[now.x][now.y] = 0;

            }
        }
    }
    public static boolean checkColRow(int x, int y, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == num || board[i][y] == num) return false;
        }
        return true;
    }

    public static boolean checkSquare(int x, int y, int num) {
        int startX = x / 3 * 3;
        int startY = y / 3 * 3;
        for (int i = startX; i < startX+3; i++) {
            for (int j = startY; j < startY+3; j++) {
                if (board[i][j] == num) return false;
            }
        }
        return true;
    }
}