import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        while (M-- > 0) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            graph[a].add(b);
        }
        int S = Integer.parseInt(br.readLine());
        boolean[] gomgomArr = new boolean[N+1];
        input = br.readLine().split(" ");
        for (int i = 0; i < S; i++) gomgomArr[Integer.parseInt(input[i])] = true;

        System.out.print(bfs(gomgomArr));
    }

    private static String bfs(boolean[] gomgomArr) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];
        q.add(1);
        visited[1] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            if (gomgomArr[now]) continue;
            if (graph[now].isEmpty()) return "yes";
            for (int next : graph[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
        return "Yes";
    }
}