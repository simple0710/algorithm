import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push")) stack.add(Integer.parseInt(st.nextToken()));
            else if (command.equals("pop")) {
                if (stack.isEmpty()) sb.append(-1);
                else sb.append(stack.pop());
                sb.append("\n");
            } else if (command.equals("size")) sb.append(stack.size()).append("\n");
            else if (command.equals("empty")) sb.append(stack.isEmpty() ? 1 : 0).append("\n");
            else sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
        }
        System.out.print(sb);
    }
}