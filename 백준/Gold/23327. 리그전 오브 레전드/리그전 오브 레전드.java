import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int Q = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        long[] prefixSum = new long[N + 1];
        long[] prefixMul = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            long v = Long.parseLong(input[i - 1]);
            if (i == 1) {
                prefixSum[i] = v;
                prefixMul[i] = 0;
            } else {
                prefixSum[i] = prefixSum[i - 1] + v;
                prefixMul[i] = prefixMul[i - 1] + v * prefixSum[i - 1];
            }
        }
        StringBuilder sb = new StringBuilder();
        while (Q-- > 0) {
            input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            sb.append(prefixMul[e] - (prefixSum[e] - prefixSum[s-1]) * prefixSum[s-1] - prefixMul[s-1]).append("\n");
        }
        System.out.print(sb);
    }
}