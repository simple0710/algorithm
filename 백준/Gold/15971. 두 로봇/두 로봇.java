import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int node;
        int dist;
        Edge(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
    static int N, A, B;
    static int[] distance;
    static ArrayList<Edge>[] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        A = Integer.parseInt(input[1]);
        B = Integer.parseInt(input[2]);
        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }
        distance = new int[N+1];
        bfs(A);
        System.out.print(A == B ? 0 : bfs(B));
    }

    public static int bfs(int start) {
        int[] nowVisited = new int[N+1];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int res = Integer.MAX_VALUE;
        q.add(start);
        while (!q.isEmpty()) {
            Integer now = q.poll();
            for (Edge next : graph[now]) {
                if (nowVisited[next.node] == 0) {
                    nowVisited[next.node] = nowVisited[now] + next.dist;
                    q.add(next.node);
                    res = Math.min(res, nowVisited[now] + distance[next.node]);
                    distance[next.node] = nowVisited[next.node];
                }
            }
        }
        distance[start] = 0;
        return res;
    }
}