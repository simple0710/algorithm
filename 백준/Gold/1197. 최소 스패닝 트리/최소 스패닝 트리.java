import java.io.*;
import java.util.*;

class Main {
    static class Edge {
        int a;
        int b;
        int weight;
        Edge(int a, int b, int weight) {
            this.a = a;
            this.b = b;
            this.weight = weight;
        }
    }
    static int[] parent;
    static ArrayList<Edge> edgeList;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int V = Integer.parseInt(input[0]);
        int E = Integer.parseInt(input[1]);
        edgeList = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            int C = Integer.parseInt(input[2]);
            edgeList.add(new Edge(A, B, C));
        }

        Collections.sort(edgeList, (o1, o2) -> o1.weight - o2.weight);

        parent = new int[V+1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        long res = 0;
        for (int i = 0; i < E; i++) {
            Edge now = edgeList.get(i);
            if (find(now.a) != find(now.b)) {
                union(now.a, now.b);
                res += now.weight;
            }
        }
        System.out.println(res);
    }

    private static int find(int x) {
        if (parent[x] != x) return find(parent[x]);
        return x;
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        parent[Math.min(a, b)] = Math.max(a, b);
    }
}