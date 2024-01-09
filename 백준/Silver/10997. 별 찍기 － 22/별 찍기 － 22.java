import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, rowLength, colLength;
    static String[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if (N == 1) System.out.println("*");
        else {
            rowLength =  3 + 4 * (N - 1);
            colLength = 1 + (N - 1) * 4;
            board = new String[rowLength][colLength];
            for (int i = 0; i < rowLength; i++) Arrays.fill(board[i], "*");
            recursion(N);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < rowLength; i++) {
                StringBuilder row = new StringBuilder();
                boolean flag = false;
                for (int j = colLength-1; j >= 0; j--) {
                    if (board[i][j].equals("*")) flag = true;
                    if (flag) row.append(board[i][j]);
                }
                sb.append(row.reverse());
                if (i != rowLength-1) sb.append("\n");
            }
            System.out.print(sb);
        }
    }
    private static void recursion(int n) {
        if (n == 1) return;
        int leftColStart = (n-1) * 2 - 1;
        int leftColEnd = rowLength - 2 * (n - 1);
        int rightRowEnd = colLength - 2 * (n - 1);
        for (int i = leftColStart; i <= leftColEnd; i++) board[i][leftColStart] = " ";
        for (int j = 2 * (n - 1); j <= rightRowEnd; j++) board[leftColEnd][j] = " ";
        for (int i = leftColStart+2; i <= leftColEnd; i++) board[i][rightRowEnd] = " ";
        for (int j = leftColStart; j <= rightRowEnd+1; j++) {
            board[leftColStart][j] = " ";
        }
        recursion(n-1);
    }
}