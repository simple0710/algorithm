import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int[][] dp;
    static ArrayList<ArrayList<Integer>> edgeList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input;

        edgeList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            edgeList.add(new ArrayList<>());
        }

        for (int i = 0; i < N-1; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            edgeList.get(u).add(v);
            edgeList.get(v).add(u);
        }

        dp = new int[N + 1][2];
        visited = new boolean[N + 1];

        search(1);

        System.out.print(Math.min(dp[1][0], dp[1][1]));
    }

    private static void search(int node) {
        visited[node] = true;
        dp[node][0] = 1;
        for (int nextNode : edgeList.get(node)) {
            if (!visited[nextNode]) {
                search(nextNode);
                dp[node][1] += dp[nextNode][0];
                dp[node][0] += Math.min(dp[nextNode][0], dp[nextNode][1]);
            }
        }
    }
}