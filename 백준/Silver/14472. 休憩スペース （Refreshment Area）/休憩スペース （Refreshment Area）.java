import java.io.*;

public class Main {
    static int[] dx = {1, 0}, dy = {0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int D = Integer.parseInt(input[2]);
        char[][] arr = new char[N][];
        for (int i = 0; i < N; i++) arr[i] = br.readLine().toCharArray();

        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == '#') continue;
                for (int k = 0; k < 2; k++) {
                    boolean flag = true;
                    for (int l = 0; l < D; l++) {
                        int ni = i + dx[k] * l;
                        int nj = j + dy[k] * l;
                        if (ni < 0 || N <= ni || nj < 0 || M <= nj || arr[ni][nj] == '#') {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) res++;
                }
            }
        }
        System.out.print(res);
    }
}