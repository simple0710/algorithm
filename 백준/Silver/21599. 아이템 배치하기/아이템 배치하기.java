import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input[i]);
        Arrays.sort(arr, Collections.reverseOrder());
        int res = 0;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            cnt = Math.max(cnt, arr[i]);
            if (cnt == 0) break;
            res++;
            cnt--;
        }
        System.out.print(res);
    }
}