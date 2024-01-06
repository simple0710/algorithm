import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String[][] defaultBoard;

    public static int search(int x, int y) {
        int whiteCnt = 0;
        int blackCnt = 0;
        for (int i = x; i < x+8; i++) {
            for (int j = y; j < y+8; j++) {
                if ((i + j) % 2 == 0 && defaultBoard[i][j].equals("B")) whiteCnt++;
                else if ((i + j) % 2 == 1 && defaultBoard[i][j].equals("W")) whiteCnt++;
                if ((i + j) % 2 == 0 && defaultBoard[i][j].equals("W")) blackCnt++;
                else if ((i + j) % 2 == 1 && defaultBoard[i][j].equals("B")) blackCnt++;
            }
        }
        return Math.min(whiteCnt, blackCnt);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        defaultBoard = new String[N][M];
        for (int i = 0; i < N; i++) {
            defaultBoard[i] = br.readLine().split("");
        }
        int res = 1000000000;
        for (int i = 0; i <= N-8; i++) {
            for (int j = 0; j <= M-8; j++) {
                res = Math.min(res, search(i, j));
            }
        }
        System.out.println(res);
    }
}