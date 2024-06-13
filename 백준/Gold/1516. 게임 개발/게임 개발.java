import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] inDegree = new int[N+1];
        ArrayList<Integer>[] graph = new ArrayList[N+1];
        long[] arr = new long[N+1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            arr[i] = Long.parseLong(input[0]);
            for (int j = 1; j < input.length - 1; j++) {
                int next = Integer.parseInt(input[j]);
                inDegree[i]++;
                graph[next].add(i);
            }
        }

        long[] dp = new long[N+1];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
                dp[i] = arr[i];
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph[now]) {
                inDegree[next]--;
                dp[next] = Math.max(dp[next], dp[now] + arr[next]);
                if (inDegree[next] == 0) q.add(next);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) sb.append(dp[i]).append("\n");
        System.out.print(sb);
    }
}
