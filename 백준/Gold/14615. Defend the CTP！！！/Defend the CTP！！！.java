import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        ArrayList<Integer>[] graphNToC, graphOneToC;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        graphNToC = new ArrayList[N+1];
        graphOneToC = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graphNToC[i] = new ArrayList<>();
            graphOneToC[i] = new ArrayList<>();
        }
        while (M-- > 0) {
            input = br.readLine().split(" ");
            int X = Integer.parseInt(input[0]);
            int Y = Integer.parseInt(input[1]);
            graphOneToC[X].add(Y);
            graphNToC[Y].add(X);
        }
        boolean[] visitedOneToC = bfs(1, graphOneToC);
        boolean[] visitedNToC = bfs(N, graphNToC);
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int C = Integer.parseInt(br.readLine());
            sb.append(visitedOneToC[C] && visitedNToC[C] ? "Defend" : "Destroyed").append(" the CTP\n");
        }
        System.out.print(sb);
    }

    private static boolean[] bfs(int s, ArrayList<Integer>[] graph) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];
        q.add(s);
        visited[s] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
        return visited;
    }
}