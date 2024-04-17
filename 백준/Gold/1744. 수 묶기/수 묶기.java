import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> mq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(br.readLine());
            if (now > 0) pq.add(now);
            else mq.add(now);
        }
        int res = 0;
        while (pq.size() >= 2) {
            int a = pq.poll();
            int b = pq.poll();
            res += b == 1 ? a + b : a * b;
        }
        if (!pq.isEmpty()) res += pq.poll();
        while (mq.size() >= 2) res += mq.poll() * mq.poll();
        if (!mq.isEmpty()) res += mq.poll();
        System.out.print(res);
    }
}