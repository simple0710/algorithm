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
    static int N, M, L, K;
    static ArrayList<Place> star, trampoline;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        L = Integer.parseInt(input[2]);
        K = Integer.parseInt(input[3]);
        star = new ArrayList<>();
        trampoline = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            star.add(new Place(a, b));
            trampoline.add(new Place(a, b));
        }
        for (Place star1 : star) {
            for (Place star2 : star) {
                trampoline.add(new Place(star1.x, star2.y));
                trampoline.add(new Place(star2.x, star1.y));
            }
        }
        int res = K;
        for (Place now :trampoline) res = Math.min(res, getMin(now));
        System.out.print(res);
    }

    private static int getMin(Place now) {
        int cnt = K;
        for (Place s : star) {
            if (now.x <= s.x && s.x <= now.x + L && now.y <= s.y && s.y <= now.y + L) cnt--;
        }
        return cnt;
    }
}