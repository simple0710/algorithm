import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] type = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) type[i] = Integer.parseInt(st.nextToken());

        Deque<Integer> nums = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int v = Integer.parseInt(st.nextToken());
            if (type[i] == 0) nums.add(v);
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int v = Integer.parseInt(st.nextToken());
            nums.addFirst(v);
            sb.append(nums.pollLast()).append(" ");
        }
        System.out.print(sb);
    }
}