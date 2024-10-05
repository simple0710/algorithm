import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int now = 0;
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int Q = Integer.parseInt(input[1]);
        int[] arr = new int[N];
        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        for (int i = 0; i < Q; i++) {
            input = br.readLine().split(" ");
            int command = Integer.parseInt(input[0]);
            if (command == 1) {
                int p = Integer.parseInt(input[1]) - 1;
                int x = Integer.parseInt(input[2]);
                int idx = (now + p) % N;
                arr[idx] += x;

            } else {
                int s = Integer.parseInt(input[1]);
                if (command == 2)  s *= -1;
                now = (now + s) % N;
                if (now < 0) now = N + now;

            }
        }
        StringBuilder sb = new StringBuilder();
        for (int d = now; d < now+N; d++) sb.append(arr[d % N]).append(" ");
        System.out.print(sb);
    }
}