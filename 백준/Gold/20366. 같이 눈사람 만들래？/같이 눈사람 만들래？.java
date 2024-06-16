import java.io.*;
import java.util.*;

public class Main {
    static int N, res;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input[i]);
        Arrays.sort(arr);
        res = Integer.MAX_VALUE;
        for (int l = 0; l < N-1; l++) {
            for (int r = l+1; r < N; r++) {
                twoPointer(l, r);
            }
        }
        System.out.print(res);
    }

    private static void twoPointer(int l, int r) {
        int sum1 = arr[l] + arr[r];
        int s = 0;
        int e = N - 1;
        while (s < e) {
            if (s == l || s == r) {
                s++;
                continue;
            }
            if (e == l || e == r) {
                e--;
                continue;
            }

            int sum2 = arr[s] + arr[e];
            res = Math.min(res, Math.abs(sum1 - sum2));

            if (sum1 > sum2) s++;
            else e--;
        }
    }
}