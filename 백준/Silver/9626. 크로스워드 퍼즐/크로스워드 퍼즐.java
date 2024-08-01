import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        int U = Integer.parseInt(input[0]);
        int L = Integer.parseInt(input[1]);
        int R = Integer.parseInt(input[2]);
        int D = Integer.parseInt(input[3]);
        int col = M+U+D;
        int row = N+L+R;
        Character[][] board = new Character[col][row];
        for (int i = U; i < col-D; i++) {
            String line = br.readLine();
            for (int j = L; j < row-R; j++) {
                board[i][j] = line.charAt(j-L);
            }
        }
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (board[i][j] == null) board[i][j] = flag ? '.' : '#';
                sb.append(board[i][j]);
                flag = !flag;
            }
            sb.append("\n");
            if (row % 2 == 0) flag = !flag;
        }
        System.out.print(sb);
    }
}