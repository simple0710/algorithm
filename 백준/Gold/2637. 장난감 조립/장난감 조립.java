import java.io.*;
import java.util.*;

public class Main {
    static int N, M, X, Y, K;
    static int[] dp, inDegree;
    static int[][] needPart;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        boolean[] defaultParts = new boolean[N+1];
        graph = new ArrayList[N+1];
        Arrays.fill(defaultParts, true);
        needPart = new int[N+1][N+1];
        inDegree = new int[N+1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            X = Integer.parseInt(input[0]);
            Y = Integer.parseInt(input[1]);
            K = Integer.parseInt(input[2]);
            graph[X].add(Y);
            inDegree[Y]++;
            needPart[X][Y] += K;
            defaultParts[X] = false;
        }
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) q.add(i);
        }
        dp = new int[N+1];
        dp[N] = 1;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph[now]) {
                dp[next] += dp[now] * needPart[now][next];
                if (--inDegree[next] == 0) q.add(next);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (defaultParts[i]) sb.append(i).append(" ").append(dp[i]).append("\n");
        }
        System.out.print(sb);
    }
}