import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        for (int i = 0; i < N; i++) {
            String Q = br.readLine().replace('0', '6').replace('6', '9');
            sum += Math.min(100, Integer.parseInt(Q));
        }
        System.out.print((int) Math.round((double) sum / N));
    }
}