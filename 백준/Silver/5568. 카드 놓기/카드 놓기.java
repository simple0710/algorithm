import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static String[] arr;
    static boolean[] visited;
    static HashSet<String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        arr = new String[N];
        for (int i = 0; i < N; i++) arr[i] = br.readLine();
        set = new HashSet<>();
        visited = new boolean[N];
        back(0, "");
        System.out.print(set.size());
    }

    private static void back(int depth, String num) {
        if (depth == K) {
            set.add(num);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                back(depth + 1, num + arr[i]);
                visited[i] = false;
            }
        }
    }
}