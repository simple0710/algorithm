import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            char[][] arr = new char[N+1][N+1];
            int[][] cntArr = new int[N+1][N+1];
            int res = 0;
            Arrays.fill(arr[0], '.');
            for (int i = 1; i <= N; i++) {
                String input = br.readLine();
                arr[i][0] = '.';
                for (int j = 1; j <= N; j++) {
                    arr[i][j] = input.charAt(j-1);
                    if (arr[i][j] == '.') {
                        cntArr[i][j] = 1;
                        if (arr[i][j-1] == '.' && arr[i-1][j] == '.' && arr[i-1][j-1] == '.') {
                            int v = Math.min(cntArr[i-1][j], cntArr[i][j-1]);
                            v = Math.min(v, cntArr[i-1][j-1]);
                            cntArr[i][j] = v + 1;
                        }
                        res = Math.max(res, cntArr[i][j]);
                    }
                }
            }
            System.out.println(res);
        }
    }
}