import java.io.*;
import java.util.*;

class Main {
    static final int NODE_CNT = 10000;
    static class Pair {
        int node, distance;
        Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
    static ArrayList<ArrayList<Pair>> tree = new ArrayList<>();
    static int maxDistance = 0;
    static int farthestNode = 0;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        for (int i = 0; i <= NODE_CNT; i++) {
            tree.add(new ArrayList<>());
        }
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            String[] parts = input.split(" ");
            int u = Integer.parseInt(parts[0]);
            int v = Integer.parseInt(parts[1]);
            int w = Integer.parseInt(parts[2]);

            tree.get(u).add(new Pair(v, w));
            tree.get(v).add(new Pair(u, w));
        }

        visited = new boolean[NODE_CNT + 1];
        dfs(1, 0);

        visited = new boolean[NODE_CNT + 1];
        maxDistance = 0;
        dfs(farthestNode, 0);

        System.out.print(maxDistance);
    }

    static void dfs(int node, int distance) {
        visited[node] = true;

        if (distance > maxDistance) {
            maxDistance = distance;
            farthestNode = node;
        }

        for (Pair next : tree.get(node)) {
            if (!visited[next.node]) {
                dfs(next.node, distance + next.distance);
            }
        }
    }
}