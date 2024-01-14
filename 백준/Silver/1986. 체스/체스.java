import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static class Place {
        int x;
        int y;
        public Place(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] board;
    static int[] qx = {-1, -1, -1, 0, 1, 1, 1, 0}, qy = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        st = new StringTokenizer(br.readLine());
        int loop = Integer.parseInt(st.nextToken());
        Place[] queenArr = new Place[loop];
        for (int i = 0; i < loop; i++) {
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            board[r-1][c-1] = 2;
            queenArr[i] = new Place(r-1, c-1);
        }

        st = new StringTokenizer(br.readLine());
        loop = Integer.parseInt(st.nextToken());
        Place[] knightArr = new Place[loop];
        for (int i = 0; i < loop; i++) {
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            board[r-1][c-1] = 2;
            knightArr[i] = new Place(r-1, c-1);
        }

        st = new StringTokenizer(br.readLine());
        loop = Integer.parseInt(st.nextToken());
        for (int i = 0; i < loop; i++) {
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            board[r-1][c-1] = 2;
        }
        
        for (Place now : queenArr) queenCheck(now.x, now.y);
        for (Place now : knightArr) knightCheck(now.x, now.y);
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) res++;
            }
        }
        System.out.print(res);
    }
    public static void dfs(int x, int y, int direction) {
        if (x < 0 || y < 0 || x >= N || y >= M || board[x][y] == 2) return;
        board[x][y] = 1;
        dfs(x + qx[direction], y + qy[direction], direction);
    }
    public static void queenCheck(int r, int c) {
        for (int i = 0; i < 8; i++) dfs(r+qx[i], c+qy[i], i);
    }
    public static void knightCheck(int r, int c) {
        int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1}, dy = {-2, -1, 1, 2, 2, 1, -1, -2};
        board[r][c] = 2;
        for (int i = 0; i < 8; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];
            if (0 <= nr && nr < N && 0 <= nc && nc < M) {
                if (board[nr][nc] != 2) board[nr][nc] = 1;
            }
        }
    }
}