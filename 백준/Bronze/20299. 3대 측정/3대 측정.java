import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int L = Integer.parseInt(input[2]);
        StringBuilder sb = new StringBuilder();
        int res = 0;
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            int min = Math.min(Math.min(a, b), c);
            int sum = a + b + c;
            if (min < L || sum < K) continue;
            res++;
            sb.append(a).append(" ").append(b).append(" ").append(c).append(" ");
        }
        System.out.println(res);
        System.out.print(sb);
    }
}