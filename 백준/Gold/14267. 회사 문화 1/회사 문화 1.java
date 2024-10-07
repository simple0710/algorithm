import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] resArr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        input = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            int p = Integer.parseInt(input[i-1]);
            if (p != -1) graph[p].add(i);
        }
        resArr = new int[N+1];
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            resArr[a] += b;
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(resArr[i]).append(" ");
        }
        System.out.print(sb);
    }

    public static void dfs(int now) {
        for (int next : graph[now]) {
            resArr[next] += resArr[now];
            dfs(next);
        }
    }
}