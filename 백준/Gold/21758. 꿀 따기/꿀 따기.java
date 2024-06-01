import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] prefixArr = new long[N+1];
        long[] arr = new long[N+1];
        String[] input = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(input[i-1]);
            prefixArr[i] = prefixArr[i-1] + arr[i];
        }
        long res = 0;
        for (int i = 2; i <= N; i++) {
            long left = prefixArr[N-1] + prefixArr[N-i] - arr[N-i+1];
            long right = prefixArr[N] * 2 - prefixArr[1] - prefixArr[i] - arr[i];
            long mid = prefixArr[i] - arr[1] + prefixArr[N] - prefixArr[i-1] - arr[N];
            res = Math.max(res, Math.max(left, right));
            res = Math.max(res, mid);
        }
        System.out.print(res);
    }
}