import java.io.*;

public class Main {
    static int N;
    static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    static int[][] arr;
    public static void main(String[] arg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int find = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        int x = 0, y = 0, d = 0;
        int num = N * N;
        int findIdxX = 0, findIdxY = 0;
        arr[0][0] = num--;
        while (0 < num) {
            while (!isOut(x + dx[d], y + dy[d])) {
                arr[(x += dx[d])][(y += dy[d])] = num;
                if (num == find) {
                    findIdxX = x;
                    findIdxY = y;
                }
                num--;
            }
            d = (d + 1) % 4;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) sb.append(arr[i][j]).append(" ");
            sb.append("\n");
        }
        sb.append(findIdxX + 1).append(" ").append(findIdxY + 1);
        System.out.print(sb);
    }

    private static boolean isOut(int x, int y) {
        return  x < 0 || N <= x || y < 0 || N <= y || arr[x][y] != 0;
    }
}