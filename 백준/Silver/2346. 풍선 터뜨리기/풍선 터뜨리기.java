import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static class Balloon {
        int idx;
        int moveCnt;

        public Balloon(int idx, int moveCnt) {
            this.idx = idx;
            this.moveCnt = moveCnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Balloon> q = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            q.add(new Balloon(i, Integer.parseInt(st.nextToken())));
        }
        StringBuilder sb = new StringBuilder();
        Balloon now = q.poll();
        sb.append(1).append(" ");
        while (!q.isEmpty()) {
            if (now.moveCnt > 0) {
                for (int i = 1; i < now.moveCnt; i++) q.add(q.poll());
            } else {
                for (int i = now.moveCnt; i <= -1; i++) q.addFirst(q.pollLast());
            }
            now = q.poll();
            sb.append(now.idx+1).append(" ");
        }
        System.out.println(sb);
    }
}