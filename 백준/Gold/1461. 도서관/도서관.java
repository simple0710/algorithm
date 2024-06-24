import java.io.*;
import java.util.*;

public class Main {
    static int N, M, p, m, last;
    static String[] input;
    static ArrayList<Integer> plus, minus;
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        plus = new ArrayList<>();
        minus = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(input[i]);
            if (now < 0) minus.add(now);
            else plus.add(now);
        }
        Collections.sort(plus, Collections.reverseOrder());
        Collections.sort(minus);

        p = getDistance(plus);
        m = getDistance(minus);
        if (!plus.isEmpty()) last = plus.get(0);
        if (!minus.isEmpty()) last = Math.max(last, -minus.get(0));

        System.out.print(p + m - last);
    }

    private static int getDistance(ArrayList<Integer> distList) {
        int idx = 0;
        int value = 0;
        while (idx < distList.size()) {
            value += Math.abs(distList.get(idx)) * 2;
            idx += M;
        }
        return value;
    }
}
