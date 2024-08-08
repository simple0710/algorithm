import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int T = Integer.parseInt(input[1]) - 1;
        int[] time = new int[1001];
        for (int i = 0; i < N; i++) {
            int K = Integer.parseInt(br.readLine());
            while (K-- > 0) {
                input = br.readLine().split(" ");
                int S = Integer.parseInt(input[0]);
                int E = Integer.parseInt(input[1]);
                for (int j = S; j < E; j++) time[j]++;
            }
        }
        int sum = 0;
        int[] res = new int[2];
        for (int i = 0; i < 1001; i++) {
            sum += time[i];
            if (i < T) continue;
            if (res[0] < sum) {
                res = new int[] {sum, i-T};
            }
            sum -= time[i-T];
        }
        System.out.print(res[1] + " " + (res[1] + T + 1));
    }
}