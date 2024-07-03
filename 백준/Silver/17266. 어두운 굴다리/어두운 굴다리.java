import java.io.*;

public class Main {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        arr = new int[M+2];
        arr[M+1] = N;
        for (int i = 1; i <= M; i++) arr[i] = Integer.parseInt(input[i-1]);
        System.out.print(binarySearch());
    }

    private static int binarySearch() {
        int s = 0;
        int e = N;
        while (s < e) {
            int mid = (s + e) / 2;
            int last = 0;
            boolean flag = true;
            for (int i = 1; i <= M; i++) {
                if (last < arr[i] - mid) {
                    flag = false;
                    break;
                }
                last = arr[i] + mid;
            }
            if (last < N) flag = false;
            if (flag) e = mid;
            else s = mid + 1;
        }
        return s;
    }
}