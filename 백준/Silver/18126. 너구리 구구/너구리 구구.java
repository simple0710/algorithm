import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int node;
        long cost;
        Edge(int node, long cost) {
            this.node = node;
            this.cost = cost;
        }
    }
    static int N;
    static ArrayList<Edge>[] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < N-1; i++) {
            String[] input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            int C = Integer.parseInt(input[2]);
            graph[A].add(new Edge(B, C));
            graph[B].add(new Edge(A, C));
        }
        System.out.print(dijkstra());
    }

    private static long dijkstra() {
        Long[] visited = new Long[N+1];
        Arrays.fill(visited, Long.MAX_VALUE);
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.cost, o2.cost));
        pq.add(new Edge(1, 0));
        visited[1] = 0L;
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            for (Edge next : graph[now.node]) {
                Long nextCost = now.cost + next.cost;
                if (visited[next.node] > nextCost) {
                    pq.add(new Edge(next.node, nextCost));
                    visited[next.node] = nextCost;
                }
            }
        }
        Long maxCost = 0L;
        for (int i = 1; i <= N; i++) {
            if (maxCost < visited[i]) {
                maxCost = visited[i];
            }
        }
        return maxCost;
    }
}