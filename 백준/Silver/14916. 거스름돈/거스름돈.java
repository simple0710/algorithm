import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= N/5; i++) {
            int now = N - 5 * i;
            if (now % 2 == 0) res = Math.min(res, i + now/2);
        }
        System.out.print(res == Integer.MAX_VALUE ? -1 : res);
    }
}