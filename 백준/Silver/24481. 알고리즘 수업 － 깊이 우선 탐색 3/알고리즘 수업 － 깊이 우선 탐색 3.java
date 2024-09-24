import java.io.*;
import java.util.*;

class Main {
    static int[] visited;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int R = Integer.parseInt(input[2]);
        graph = new ArrayList[N+1];
        visited = new int[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            visited[i] = -1;
        }
        while (M-- > 0) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            graph[u].add(v);
            graph[v].add(u);
        }

        visited[R] = 0;
        for (int i = 1; i <= N; i++) Collections.sort(graph[i]);

        dfs(R);

        for (int i = 1; i <= N; i++) System.out.println(visited[i]);
    }

    private static void dfs(int now) {
        for (int next : graph[now]) {
            if (visited[next] == -1) {
                visited[next] = visited[now] + 1;
                dfs(next);
            }
        }
    }
}