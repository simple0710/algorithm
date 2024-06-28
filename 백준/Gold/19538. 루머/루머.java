import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] visited, cntArr;
    static ArrayList<ArrayList<Integer>> graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            graph.add(new ArrayList<>());
            for (int j = 0; j < input.length - 1; j++) {
                graph.get(i).add(Integer.parseInt(input[j]) - 1);
            }
        }
        M = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        input = br.readLine().split(" ");
        visited = new int[N];
        Arrays.fill(visited, -1);
        for (int i = 0; i < M; i++) {
            int now = Integer.parseInt(input[i]) - 1;
            q.add(now);
            visited[now] = 0;
        }
        bfs(q);
        StringBuilder sb = new StringBuilder();
        for (int num : visited) sb.append(num).append(" ");
        System.out.print(sb);
    }

    private static void bfs(Queue<Integer> q) {
        cntArr = new int[N];
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph.get(now)) {
                if (visited[next] == -1 && cntArr[next] < getCenter(next)) {
                    cntArr[next]++;
                    if (cntArr[next] == getCenter(next)) {
                        q.add(next);
                        visited[next] = visited[now] + 1;
                    }
                }
            }
        }
    }

    private static int getCenter(int num) {
        return graph.get(num).size() / 2 + graph.get(num).size() % 2;
    }
}