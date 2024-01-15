import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        int[] resArr = new int[N];
        for (int i = 0; i < N; i++) resArr[i] = Integer.parseInt(br.readLine());
        int idx = 0;
        for (int i = 1; i <= N+1; i++) {
            while (!stack.isEmpty() && stack.peek() == resArr[idx]) {
                stack.pop();
                sb.append("-").append("\n");
                idx++;
            }
            if (i <= N) {
                stack.add(i);
                sb.append("+").append("\n");
            }
        }
        if (stack.isEmpty()) System.out.print(sb);
        else System.out.println("NO");
    }
}