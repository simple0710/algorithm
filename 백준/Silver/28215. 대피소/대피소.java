import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N, K, res;
    static int[] pick;
    static boolean[] visited;
    static ArrayList<Point> list;
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        list = new ArrayList();
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            list.add(new Point(x, y));
        }
        pick = new int[K];
        visited = new boolean[N];
        res = Integer.MAX_VALUE;
        back(0, 0);
        System.out.print(res);
    }

    private static void back(int depth, int now) {
        if (depth == K) {
            int value = 0;
            for (int i = 0; i < N; i++) {
                int check = Integer.MAX_VALUE;
                Point a = list.get(i);
                if (!visited[i]) {
                    for (int j = 0; j < K; j++) {
                        Point b = list.get(pick[j]);
                        check = Math.min(check, Math.abs(a.x - b.x) + Math.abs(a.y - b.y));
                    }
                    value = Math.max(value, check);
                }
            }
            res = Math.min(res, value);
            return;
        }

        for (int i = now; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                pick[depth] = i;
                back(depth + 1, i);
                visited[i] = false;
            }
        }
    }
}