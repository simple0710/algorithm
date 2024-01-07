import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static boolean[] visited;
    static boolean[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            graph = new boolean[N+1][N+1];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a][b] = true;
                graph[b][a] = true;
            }
            visited = new boolean[N + 1];
            int res = 0;
            for (int i = 1; i < N+1; i++) {
                if (!visited[i]) {
                    bfs(i);
                    res++;
                }
            }
            System.out.println(String.format("#%d %d", t, res));
        }
    }

    public static void bfs(int v) {
        Deque<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < N+1; i++) {
                if (graph[now][i] && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}