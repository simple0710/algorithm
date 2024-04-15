import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] st = br.readLine().split(" ");
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st[i]);
        Arrays.sort(arr);
        int sum = 0, wait = 0;
        for (int i = 0; i < N; i++) sum += (wait += arr[i]);
        System.out.print(sum);
    }
}