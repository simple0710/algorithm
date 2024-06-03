import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int L = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input[i]);
        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            if (arr[i] <= L) L++;
        }
        System.out.print(L);
    }
}