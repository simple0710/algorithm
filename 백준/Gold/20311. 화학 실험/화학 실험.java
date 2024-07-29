import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        int[] colorCnt = new int[K+1];
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> colorCnt[o2] - colorCnt[o1]);
        for (int i = 1; i <= K; i++) {
            colorCnt[i] = Integer.parseInt(input[i-1]);
            pq.add(i);
        }
        StringBuilder sb = new StringBuilder();
        int idx = 1;
        int[] resArr = new int[N+1];
        while (!pq.isEmpty() && idx <= N) {
            int now = pq.poll();
            if (now == resArr[idx-1]) {
                if (pq.isEmpty()) break;
                int temp = now;
                now = pq.poll();
                pq.add(temp);
            }
            colorCnt[now]--;
            if (colorCnt[now] > 0) pq.add(now);
            sb.append(resArr[idx++] = now).append(" ");
        }
        System.out.print(idx <= N ? -1 : sb);
    }
}