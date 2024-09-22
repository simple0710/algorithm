import java.io.*;
import java.util.*;

class Main {
    static class Info {
        char type;
        int p;
        Info(char type, int p) {
            this.type = type;
            this.p = p;
        }
    }
    static class Place {
        int room;
        int money;
        Place(int room, int money) {
            this.room = room;
            this.money = money;
        };
    }
    static int N;
    static ArrayList<Integer>[] graph;
    static int[] visited;
    static Info[] board;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        StringBuilder sb = new StringBuilder();
        while ((N = Integer.parseInt(br.readLine())) != 0) {
            graph = new ArrayList[N];
            board = new Info[N];
            visited = new int[N];
            Arrays.fill(visited, -1);
            for (int i = 0; i < N; i++) {
                input = br.readLine().split(" ");
                graph[i] = new ArrayList<>();

                char type = input[0].charAt(0);
                int p = Integer.parseInt(input[1]);
                board[i] = new Info(type, p);
                for (int j = 2; j < input.length - 1; j++) {
                    graph[i].add(Integer.parseInt(input[j]) - 1);
                }
            }
            sb.append(bfs()).append("\n");
        }
        System.out.print(sb);
    }

    private static String bfs() {
        ArrayDeque<Place> q = new ArrayDeque<>();
        q.add(new Place(0, 0));
        while (!q.isEmpty()) {
            Place now = q.poll();
            if (now.room == N-1) return "Yes";
            if (visited[now.room] > now.money) continue;

            for (int next : graph[now.room]) {
                int nextMoney = now.money;
                if (board[next].type == 'L') nextMoney = Math.max(board[next].p, now.money);
                else if (board[next].type == 'T') {
                    if (now.money < board[next].p) continue;
                    nextMoney = now.money - board[next].p;
                }
                if (nextMoney > visited[next]) {
                    q.add(new Place(next, nextMoney));
                    visited[next] = nextMoney;
                }
            }
        }
        return "No";
    }
}