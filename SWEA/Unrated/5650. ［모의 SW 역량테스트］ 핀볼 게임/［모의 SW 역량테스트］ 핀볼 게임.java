import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int N;
    static int[][] board;
    static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    static int[][][] visited;
    static Hole[][] hole;
    static class Hole {
        int x;
        int y;
        public Hole(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine().trim());
            board = new int[N][N];
            hole = new Hole[5][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    if (board[i][j] >= 6) {
                        int holeNumber = board[i][j] - 6;
                        for (int h = 0; h < hole[holeNumber].length; h++) {
                            if (hole[holeNumber][h] == null) {
                                hole[holeNumber][h] = new Hole(i, j);
                                break;
                            }
                        }
                    }
                }
            }
            int res = 0;
            visited = new int[4][N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == 0) {
                        for (int d = 0; d < 4; d++) {
                            res = Math.max(res, implementation(i, j, d));
                        }
                    }
                }
            }
            System.out.printf("#%d %d%n", t, res);
        }
    }
    public static int implementation(int startX, int startY, int d) {
        int px = startX;
        int py = startY;
        int cnt = 0;
        while (true) {
            px += dx[d];
            py += dy[d];
            if (px < 0 || px >= N || py < 0 || py >= N) {
                d = (d + 2) % 4;
                cnt++;
                continue;
            }
            if (visited[d][px][py] > 0) {
                visited[d][px][py] = cnt + visited[d][px][py];
                return cnt + visited[d][px][py];
            }
            if ((px == startX && py == startY) || board[px][py] == -1) {
                return cnt;
            }
            if (6 <= board[px][py]) {
                int holeNumber = board[px][py] - 6;
                if (hole[holeNumber][0].x == px && hole[holeNumber][0].y == py){
                    px = hole[holeNumber][1].x;
                    py = hole[holeNumber][1].y;
                } else {
                    px = hole[holeNumber][0].x;
                    py = hole[holeNumber][0].y;
                }
            }
            else if (1 <= board[px][py]) {
                cnt++;
                d = turnDirection(d, board[px][py]);
            }
        }
    }

    public static int turnDirection(int d, int t) {
        int[] turnType;
        if (t == 1) {
            turnType = new int[] {1, 3, 0, 2};
        } else if (t == 2) {
            turnType = new int[] {2, 3, 1, 0};
        } else if (t == 3) {
            turnType = new int[] {2, 0, 3, 1};
        } else if (t == 4) {
            turnType = new int[] {3, 2, 0, 1};
        } else return (d + 2) % 4;
        return turnType[d];
    }
}