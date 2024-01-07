import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "1": stack.push(st.nextToken());
                    break;
                case "2":
                    sb.append(!stack.isEmpty() ? stack.pop() : -1).append("\n");
                    break;
                case "3": sb.append(stack.size()).append("\n");
                    break;
                case "4": sb.append(!stack.isEmpty() ? 0 : 1).append("\n");
                    break;
                case "5" : sb.append(!stack.isEmpty() ? stack.peek() : -1).append("\n");
            }
        }
        System.out.println(sb);
    }
}