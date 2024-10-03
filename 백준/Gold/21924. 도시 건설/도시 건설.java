import java.io.*;
import java.util.*;

public class Main {
    static class Info {
        int a;
        int b;
        int c;
        Info(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        ArrayList<Info> list = new ArrayList<>();
        long total = 0;
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            list.add(new Info(a, b, c));
            total += c;
        }

        Collections.sort(list, (o1, o2) -> o1.c - o2.c);

        parent = new int[N+1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
        for (Info now : list) {
            if (find(now.a) != find(now.b)) {
                union(now.a, now.b);
                total -= now.c;
            }
        }
        for (int i = 1; i <= N; i++) {
            if (find(parent[i]) != 1) {
                total = -1;
                break;
            }
        }
        System.out.print(total);
    }

    private static int find(int x) {
        if (parent[x] != x) return parent[x] = find(parent[x]);
        return parent[x];
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        parent[Math.max(a, b)] = Math.min(a, b);
    }
}