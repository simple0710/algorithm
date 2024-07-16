import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N, M, P, L, res;
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        Integer[] now;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1-o2);
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            P = Integer.parseInt(input[0]);
            L = Integer.parseInt(input[1]);
            input = br.readLine().split(" ");
            now = new Integer[P];
            for (int j = 0; j < P; j++) now[j] = Integer.parseInt(input[j]);
            Arrays.sort(now, Collections.reverseOrder());
            pq.add(P < L ? 1 : now[L-1]);
        }
        res = 0;
        while (!pq.isEmpty() && (M-=pq.poll()) >= 0) res++;
        System.out.print(res);
    }
}