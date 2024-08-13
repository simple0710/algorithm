import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[] inDegree = new int[N+1];
        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList();
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            graph[A].add(B);
            inDegree[B]++;
        }
        int[] resArr = new int[N+1];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
                resArr[i] = 1;
            }
        }
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph[now]) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    q.add(next);
                    resArr[next] = resArr[now] + 1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) sb.append(resArr[i]).append(" ");
        System.out.print(sb);
    }
}