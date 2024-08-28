import java.io.*;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        System.out.print(twoPointer());
    }

    private static int twoPointer() {
        int s = 0;
        int e = N-1;
        int res = 200_000_001;
        while (s < e) {
            int value = arr[s] + arr[e];
            if (Math.abs(res) > Math.abs(value)) res = value;
            if (value < 0) s++;
            else e--;
        }
        return res;
    }
}