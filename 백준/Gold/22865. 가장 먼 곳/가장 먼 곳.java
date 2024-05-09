import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static class Edge {
        int node;
        int dist;
        Edge(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
    static int N, A, B, C;
    static ArrayList<Edge>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        A = Integer.parseInt(input[0]);
        B = Integer.parseInt(input[1]);
        C = Integer.parseInt(input[2]);
        int M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        while (M-- > 0) {
            input = br.readLine().split(" ");
            int D = Integer.parseInt(input[0]);
            int E = Integer.parseInt(input[1]);
            int L = Integer.parseInt(input[2]);
            graph[D].add(new Edge(E, L));
            graph[E].add(new Edge(D, L));
        }
        System.out.print(dijkstra());
    }

    private static int dijkstra() {
        int[] visited = new int[N+1];
        Arrays.fill(visited, INF);
        visited[A] = 0;
        visited[B] = 0;
        visited[C] = 0;
        int max = -1;
        int res = 0;
        PriorityQueue<Edge> q = new PriorityQueue<>(new Comparator<Edge> () {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.dist - o2.dist;
            }
        });
        q.add(new Edge(A, 0));
        q.add(new Edge(B, 0));
        q.add(new Edge(C, 0));
        while (!q.isEmpty()) {
            Edge now = q.poll();
            if (visited[now.node] < now.dist) continue;
            if (max < now.dist) {
                max = now.dist;
                res = now.node;
            } else if (max == now.dist) {
                res = Math.min(res, now.node);
            }
            for (Edge next : graph[now.node]) {
                int nextDist = now.dist + next.dist;
                if (visited[next.node] > nextDist) {
                    q.add(new Edge(next.node, nextDist));
                    visited[next.node] = nextDist;
                }
            }
        }
        return res;
    }
}