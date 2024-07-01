import java.io.*;
import java.util.*;

public class Main {
    static String[] input;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        Queue<Integer> q = new LinkedList<>();
        int[] inDegree = new int[N+1];
        int[] time = new int[N+1];
        int[] resArr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            input = br.readLine().split(" ");
            int t = Integer.parseInt(input[0]);
            int cnt = Integer.parseInt(input[1]);
            graph[i] = new ArrayList<>();
            time[i] = t;
            for (int j = 0; j < cnt; j++) {
                int next = Integer.parseInt(input[j+2]);
                graph[next].add(i);
                inDegree[i]++;
            }
            resArr[i] = t;
        }

        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph[now]) {
                inDegree[next]--;
                resArr[next] = Math.max(resArr[next], resArr[now] + time[next]);
                if (inDegree[next] == 0) q.add(next);
            }
        }
        int res = 0;
        for (int i = 1; i <= N; i++) res = Math.max(res, resArr[i]);
        System.out.print(res);
    }
}