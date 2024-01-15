import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] tower = new int[N];
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i ++) {
            int height = Integer.parseInt(st.nextToken());
            tower[i] = height;
            while (!stack.isEmpty() && tower[stack.peek()] < height) {
                stack.pop();
            }
            sb.append(stack.isEmpty() ? 0 : stack.peek() + 1).append(" ");
            stack.add(i);
        }
        System.out.print(sb);
    }
}