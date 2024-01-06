import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] defaultBoard;

    public static int search(int x, int y) {
        int cnt = 0;
        boolean color = defaultBoard[x][y];
        for (int i = x; i < x+8; i++) {
            for (int j = y; j < y+8; j++) {
                if (color != defaultBoard[i][j]) cnt++;
                color = !color;
            }
            color = !color;
        }
        return Math.min(64-cnt, cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        defaultBoard = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                if (row[j].equals("W")) defaultBoard[i][j] = true;
                else defaultBoard[i][j] = false;
            }
        }
        int res = 64;
        for (int i = 0; i <= N-8; i++) {
            for (int j = 0; j <= M-8; j++) {
                res = Math.min(res, search(i, j));
            }
        }
        System.out.println(res);
    }
}