import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int[][] board;

    public static class Player {
        int x;
        int y;
        int turn;

        public Player(int x, int y, int turn) {
            this.x = x;
            this.y = y;
            this.turn = turn;
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            board = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) board[i][j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int C = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            System.out.printf("#%d %d%n", t, bfs(A, B, C, D));
        }
    }
    public static int bfs(int A, int B, int C, int D) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        boolean[][] visited = new boolean[N][N];
        Deque<Player> q = new LinkedList<>();
        q.add(new Player(A, B, 0));
        visited[A][B] = true;
        while (!q.isEmpty()) {
            Player now = q.poll();
            if (now.x == C && now.y == D) return now.turn;
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny] && board[nx][ny] != 1) {
                    if (board[nx][ny] == 2 && (now.turn+1) % 3 != 0) {
                        q.add(new Player(now.x, now.y, now.turn+1));
                    } else {
                        q.add(new Player(nx, ny, now.turn+1));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return -1;
    }
}