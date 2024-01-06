import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        boolean[][] board = new boolean[101][101];
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int bottom = Integer.parseInt(st.nextToken());
            for (int i = left+1; i <= left+10; i++) {
                for (int j = bottom+1; j <= bottom+10; j++) {
                    board[i][j] = true;
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (board[i][j]) res++;
            }
        }
        System.out.println(res);
    }
}