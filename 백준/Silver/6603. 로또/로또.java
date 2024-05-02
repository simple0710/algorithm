import java.io.*;

public class Main {
    static int N;
    static int[] pick, arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        while (!(input = br.readLine().split(" "))[0].equals("0")) {
            N = Integer.parseInt(input[0]);
            arr = new int[N];
            for (int i = 1; i <= N; i++) arr[i-1] = Integer.parseInt(input[i]);
            pick = new int[6];
            back(new boolean[N], 0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void back(boolean[] visited, int depth, int now) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) sb.append(pick[i]).append(" ");
            sb.append("\n");
            return;
        }
        for (int i = now; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                pick[depth] = arr[i];
                back(visited, depth + 1, i);
                visited[i] = false;
            }
        }
    }
}