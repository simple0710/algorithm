import java.io.*;
import java.util.*;

public class Main {
    static int N, Q;
    static int[] parent;
    static ArrayList<int[]> edge;
    public static void main(String[] args) throws Exception {
        int from, to, cost, time, edgeCnt, totalTime;
        long totalCost;
        String[] input;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        Q = Integer.parseInt(input[1]);
        edge = new ArrayList<>();
        for (int i = 0; i < Q; i++) {
            input = br.readLine().split(" ");
            from = Integer.parseInt(input[0]);
            to = Integer.parseInt(input[1]);
            cost = Integer.parseInt(input[2]);
            time = Integer.parseInt(input[3]);
            edge.add(new int[] {from, to, cost, time});
        }
        Collections.sort(edge, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[2] == o2[2]) return Integer.compare(o1[3], o2[3]);
                return Integer.compare(o1[2], o2[2]);
            }
        });
        parent = new int[N+1];
        edgeCnt = 0;
        totalCost = 0;
        totalTime = 0;
        for (int i = 1; i <= N; i++) parent[i] = i;
        for (int i = 0; i < Q; i++) {
            int[] now = edge.get(i);
            if (find(now[0]) != find(now[1])) {
                union(now[0], now[1]);
                totalCost += now[2];
                totalTime = Math.max(totalTime, now[3]);
                edgeCnt++;
            }
        }
        System.out.print(edgeCnt == N - 1 ? totalTime + " " + totalCost : -1);
    }
    private static int find(int x) {
        if (parent[x] != x) return parent[x] = find(parent[x]);
        return x;
    }

    private static void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        parent[Math.max(a, b)] = Math.min(a, b);
    }
}