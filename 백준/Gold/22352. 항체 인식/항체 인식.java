import java.io.*;
import java.util.*;

public class Main {
    static class Place {
        int x;
        int y;
        Place(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N, M;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int[][] arr, targetArr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) arr[i][j] = Integer.parseInt(input[j]);
        }
        
        targetArr = new int[N][M];
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) targetArr[i][j] =  Integer.parseInt(input[j]);
        }

        fillArr();

        System.out.print(check() ? "YES" : "NO");
    }

    private static void bfs(int x, int y) {
        ArrayDeque<Place> q = new ArrayDeque<>();
        q.add(new Place(x, y));
        int firstNum = arr[x][y];
        arr[x][y] = targetArr[x][y];
        while (!q.isEmpty()) {
            Place now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (!isOut(nx, ny) && arr[nx][ny] == firstNum) {
                    arr[nx][ny] = targetArr[x][y];
                    q.add(new Place(nx, ny));
                }
            }
        }
    }
    private static void fillArr() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] != targetArr[i][j]) {
                    bfs(i, j);
                    return;
                }
            }
        }
    }
    private static boolean isOut(int x, int y) {
        return x < 0 || N <= x || y < 0 || M <= y;
    }

    private static boolean check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] != targetArr[i][j]) return false;
            }
        }
        return true;
    }
}