import java.io.*;
import java.util.*;

class Main {
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        parent = new int[N+1];
        ArrayList<int[]> graphList = new ArrayList<>();
        for (int i = 1; i <= N; i++) parent[i] = i;
        while (M-- > 0) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            graphList.add(new int[] {u, v});
        }
        int res = 0;
        for (int[] now : graphList) {
            int a = now[0];
            int b = now[1];
            if (find(a) != find(b)) union(a, b);
            else res++;
        }
        boolean[] check = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            parent[i] = find(i);
            if (!check[parent[i]]) {
                res++;
                check[parent[i]] = true;
            }
        }
        System.out.print(res - 1);
    }

    private static int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        parent[Math.max(a, b)] = Math.min(a, b);
    }
}