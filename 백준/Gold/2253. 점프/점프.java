import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 10001;
    static int N, M;
    static boolean[] cantMove;
    static HashSet<Integer>[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        visited = new HashSet[N+1];
        cantMove = new boolean[N+1];
        for (int i = 0; i <= N; i++) visited[i] = new HashSet<>();
        while (M-- > 0) cantMove[Integer.parseInt(br.readLine())] = true;
        System.out.print(bfs());
    }

    private static int bfs() {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[] {1, 0, 0});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (now[0] == N) return now[2];
            for (int jump : new int[] {now[1] - 1, now[1], now[1] + 1}) {
                int next_place = now[0] + jump;
                if (jump <= 0 || next_place > N) continue;
                if (!cantMove[next_place] && !visited[next_place].contains(jump)) {
                    visited[next_place].add(jump);
                    q.add(new int[] {next_place, jump, now[2] + 1});
                }
            }
        }
        return -1;
    }
}