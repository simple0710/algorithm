import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] timeArr = new boolean[1441];
        int N = Integer.parseInt(br.readLine());
        int startTime = 600;
        int endTime = 1320;

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int S = Integer.parseInt(input[0]);
            int E = Integer.parseInt(input[1]);

            S = S / 100 * 60 + S % 100 - 10;
            E = E / 100 * 60 + E % 100 + 10;

            for (int t = S; t < E; t++) {
                timeArr[t] = true;
            }
        }

        int cnt = 0;
        int res = 0;
        for (int i = startTime; i < endTime; i++) {
            if (!timeArr[i]) {
                cnt++;
            } else {
                res = Math.max(res, cnt);
                cnt = 0;
            }
        }
        res = Math.max(res, cnt);
        System.out.print(res);
    }
}