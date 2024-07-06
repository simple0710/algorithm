import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        PriorityQueue<Integer>[] pqArr = new PriorityQueue[200_001];
        for (int i = 1; i < 200001; i++) pqArr[i] = new PriorityQueue<>((o1, o2) -> o1-o2);

        for (int i = 1; i <= N; i++) {
            input = br.readLine().split(" ");
            int cnt = Integer.parseInt(input[0]);
            for (int j = 1; j <= cnt; j++) {
                pqArr[Integer.parseInt(input[j])].add(i);
            }
        }

        input = br.readLine().split(" ");
        int[] resArr = new int[N+1];
        for (int i = 0 ; i < M; i++) {
            int v = Integer.parseInt(input[i]);
            if (!pqArr[v].isEmpty()) resArr[pqArr[v].poll()]++;
        }
        for (int i = 1; i <= N; i++) System.out.print(resArr[i] + " ");
    }
}