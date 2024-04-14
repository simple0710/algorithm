import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int N = Integer.parseInt(st[0]);
        int S = Integer.parseInt(st[1]);
        st = br.readLine().split(" ");
        long[] arr = new long[N+1];
        for (int i = 1; i <= N; i++) arr[i] = arr[i-1] + Integer.parseInt(st[i-1]);
        int s = 0;
        int res = N+1;
        long sum;
        for (int e = 1; e <= N; e++) {
            while (s <= e && (sum = arr[e] - arr[s]) >= S) {
                if (sum >= S) res = Math.min(res, e - s);
                s++;
            }
        }
        System.out.print(res == N + 1 ? 0 : res);
    }
}