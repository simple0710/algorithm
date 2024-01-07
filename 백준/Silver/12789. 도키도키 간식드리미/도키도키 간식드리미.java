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
        Stack<Integer> stack = new Stack<>();
        int cnt = 1;
        for (int i = 0; i < N; i++) {
            stack.push(Integer.parseInt(st.nextToken()));
            while (!stack.isEmpty() && stack.peek() == cnt) {
                cnt++;
                stack.pop();
            }
        }
        System.out.println(stack.isEmpty() ? "Nice" : "Sad");
    }
}