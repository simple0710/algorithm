import java.io.*;
import java.util.*;

class Main {
    static class Edge {
        int node;
        int dist;
        Edge(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
    static int V, farthestNode;
    static long maxDistance;
    static boolean[] visited;
    static ArrayList<ArrayList<Edge>> tree = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        for (int i = 0; i <= V; i++) tree.add(new ArrayList<>());

        for (int i = 0; i < V; i++) {
            String[] input = br.readLine().split(" ");
            int now = Integer.parseInt(input[0]);
            for (int j = 1; j < input.length - 1; j+=2) {
                int next = Integer.parseInt(input[j]);
                int dist = Integer.parseInt(input[j+1]);
                tree.get(now).add(new Edge(next, dist));
                tree.get(next).add(new Edge(now, dist));
            }
        }
        visited = new boolean[V+1];
        dfs(1, 0);

        visited = new boolean[V+1];
        maxDistance = 0;
        dfs(farthestNode, 0);

        System.out.print(maxDistance);
    }

    private static void dfs(int now, int dist) {
        visited[now] = true;
        if (dist > maxDistance) {
            maxDistance = dist;
            farthestNode = now;
        }
        for (Edge next : tree.get(now)) {
            if (!visited[next.node]) {
                dfs(next.node, dist + next.dist);
            }
        }
    }
}