import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[][] arr = new int[N][M];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = M == 1 ? i % 2 + 1 : j % 2 + (i % 2 == 0 ? 1 : 3);
                sb.append(arr[i][j]).append(" ");
                set.add(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(set.size());
        System.out.print(sb);
    }
}