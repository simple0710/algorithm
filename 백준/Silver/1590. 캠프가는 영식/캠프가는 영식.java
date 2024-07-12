import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N, T, S, I, C, res;
        N = Integer.parseInt(input[0]);
        T = Integer.parseInt(input[1]);
        res = Integer.MAX_VALUE;
        while (N-- > 0) {
            input = br.readLine().split(" ");
            S = Integer.parseInt(input[0]);
            I = Integer.parseInt(input[1]);
            C = Integer.parseInt(input[2]);
            if (S >= T) res = Math.min(res, S - T);
            else if ((T - S - 1) / I + 1 < C) res = Math.min(res, S + I * ((T - S - 1) / I + 1) - T);
        }
        System.out.print(res == Integer.MAX_VALUE ? -1 : res);
    }
}