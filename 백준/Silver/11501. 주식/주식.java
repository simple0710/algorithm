import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            String[] st = br.readLine().split(" ");
            int[] arr = new int[N];
            int[] maxArr = new int[N+1];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st[i]);
            for (int i = N-1; i >= 0; i--) maxArr[i] = Math.max(arr[i], maxArr[i+1]);
            long res = 0;
            for (int i = 0; i < N-1; i++) res += Math.max(maxArr[i] - arr[i], 0);
            System.out.println(res);
        }
    }
}