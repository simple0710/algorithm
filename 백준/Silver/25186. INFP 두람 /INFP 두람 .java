import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        long sum = 0;
        long max = 0;
        for (int i = 0; i < N; i++) {
            long v = Long.parseLong(input[i]);
            sum += v;
            max = Math.max(max, v);
        }
        String res = max > sum / 2 ? "Unhappy" : "Happy";
        if (sum == 1) res = "Happy";
        System.out.print(res);
    }
}