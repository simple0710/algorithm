import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] knowArr;
    static ArrayList<Integer>[] graph, party;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        knowArr = new boolean[N+1];
        st = new StringTokenizer(br.readLine());
        st.nextToken();
        ArrayDeque<Integer> q = new ArrayDeque<>();
        boolean[] knowArr = new boolean[N+1];
        while (st.hasMoreTokens()) {
            int know = Integer.parseInt(st.nextToken());
            knowArr[know] = true;
            q.add(know);
        }
        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        
        party = new ArrayList[M+1];
        for (int i = 0; i < M; i++) {
            party[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            while (st.hasMoreTokens()) {
                int now = Integer.parseInt(st.nextToken());
                graph[now].add(i);
                party[i].add(now);
            }
        }
        System.out.println(bfs(q, knowArr));
    }

    public static int bfs(ArrayDeque<Integer> q, boolean[] knowArr) {
        boolean[] partyVisited = new boolean[M];
        while (!q.isEmpty()) {
            Integer now = q.poll();
            for (int p : graph[now]) {
                if (!partyVisited[p]) {
                    partyVisited[p] = true;
                    for (int participant : party[p]) {
                        if (!knowArr[participant]) {
                            knowArr[participant] = true;
                            q.add(participant);
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < M; i++) {
            if (!partyVisited[i]) res++;
        }
        return res;
    }
}