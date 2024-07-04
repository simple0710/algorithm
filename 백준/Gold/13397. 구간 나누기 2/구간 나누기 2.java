import java.io.*;

public class Main {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input[i]);
        System.out.print(binarySearch());
    }

    private static int binarySearch() {
        int s = 0;
        int e = 10000;
        int res = 100000;
        while (s < e) {
            int mid = (s + e) / 2;
            int max = 0;
            int min = 10000;
            int cnt = 0;
            int checkV = 0;
            for (int i = 0; i < N; i++) {
                max = Math.max(max, arr[i]);
                min = Math.min(min, arr[i]);
                if (max - min > mid) {
                    max = arr[i];
                    min = arr[i];
                    cnt++;
                }
                checkV = Math.max(checkV, max - min);
            }
            if (cnt <= M - 1) {
                e = mid;
                res = Math.min(res, checkV);
            }
            else s = mid + 1;
        }
        return res;
    }
}