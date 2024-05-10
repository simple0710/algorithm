import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static class Edge implements Comparable<Edge> {
        int node;
        int dist;
        Edge(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.dist, o.dist);
        }
    }
    static int N;
    static int[] resVisited;
    static ArrayList<Edge>[] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            graph = new ArrayList[N+1];
            resVisited = new int[N+1];
            for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
            while (M-- > 0) {
                input = br.readLine().split(" ");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);
                int c = Integer.parseInt(input[2]);
                graph[a].add(new Edge(b, c));
                graph[b].add(new Edge(a, c));
            }
            int K = Integer.parseInt(br.readLine());
            input = br.readLine().split(" ");
            for (int i = 0; i < K; i++) dijkstra(Integer.parseInt(input[i]));
            int min = INF;
            int res = 0;
            for (int i = 1; i <= N; i++) {
                if (min > resVisited[i]) {
                    min = resVisited[i];
                    res = i;
                }
            }
            System.out.println(res);
        }
    }
    private static void dijkstra(int num) {
        PriorityQueue<Edge> q = new PriorityQueue<>();
        int[] visited = new int[N+1];
        Arrays.fill(visited, INF);
        visited[num] = 0;
        q.add(new Edge(num, 0));
        while (!q.isEmpty()) {
            Edge now = q.poll();
            for (Edge next : graph[now.node]) {
                int nextDist = now.dist + next.dist;
                if (visited[next.node] > nextDist) {
                    visited[next.node] = nextDist;
                    q.add(new Edge(next.node, nextDist));
                }
            }
        }
        for (int i = 1; i <= N; i++) resVisited[i] += visited[i];
    }
}