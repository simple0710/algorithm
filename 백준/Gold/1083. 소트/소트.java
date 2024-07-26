import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input[i]);
        int S = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int changeIdx = i;
            int nowNum = arr[i];
            int endIdx = Math.min(N-1, i + S);
            for (int j = i + 1; j <= endIdx; j++) {
                if (nowNum < arr[j]) {
                    changeIdx = j;
                    nowNum = arr[j];
                }
            }
            if (i != changeIdx) {
                sort(arr, i, changeIdx);
                S -= (changeIdx - i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int v : arr) sb.append(v).append(" ");
        System.out.print(sb);
    }

    private static void sort(int[] arr, int start, int end) {
        for (int i = end; i > start; i--) {
            int temp = arr[i-1];
            arr[i-1] = arr[i];
            arr[i] = temp;
        }
    }
}