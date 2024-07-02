import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int S = Integer.parseInt(input[1]);
            int E = Integer.parseInt(input[2]);
            int res = 0;
            if (N != 2 && Math.abs(S - E) == 1) res = 1;
            else {
                if (E != 1 && E != N) res++;
                if (S != 1 && S != N) res = 2;
            }
            System.out.println(res);
        }
    }
}