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
    static int N, M, H, res;
    static boolean[] visited;
    static ArrayList<Place> mintMilkList;
    static Place home;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        H = Integer.parseInt(input[2]);
        mintMilkList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                if (input[j].equals("1")) {
                    home = new Place(i, j);
                } else if (input[j].equals("2")) {
                    mintMilkList.add(new Place(i, j));
                }
            }
        }
        res = 0;
        visited = new boolean[mintMilkList.size()];
        back(0, home, M);
        System.out.print(res);
    }

    private static void back(int depth, Place now, int hp) {
        int homeDistance = Math.abs(home.x - now.x) + Math.abs(home.y - now.y);
        if (hp >= homeDistance) res = Math.max(res, depth);
        if (depth == mintMilkList.size()) return;
        for (int i = 0; i < mintMilkList.size(); i++) {
            if (!visited[i]) {
                Place next = mintMilkList.get(i);
                int distance = Math.abs(now.x - next.x) + Math.abs(now.y - next.y);
                int nextHp = hp - distance;
                if (nextHp >= 0) {
                    visited[i] = true;
                    back(depth + 1, next, nextHp + H);
                    visited[i] = false;
                }
            }
        }
    }
}