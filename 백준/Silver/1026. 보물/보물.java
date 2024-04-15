import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        Integer[] B = new Integer[N];
        String[] stA = br.readLine().split(" ");
        String[] stB = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(stA[i]);
            B[i] = Integer.parseInt(stB[i]);
        }
        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());
        int res = 0;
        for (int i = 0; i < N; i++) res += A[i] * B[i];
        System.out.print(res);
    }
}