import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int res = 0;
        int v = 1;
        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);
            if (now == '(') {
                stack.add(now);
                v *= 2;
            } else if (now == '[') {
                stack.add(now);
                v *= 3;
            }
            else if (now == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    res = 0;
                    break;
                } else if (str.charAt(i-1) == '(') {
                    res += v;
                }
                stack.pop();
                v /= 2;
            }
            else if (now == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    res = 0;
                    break;
                } else if (str.charAt(i-1) == '[') {
                    res += v;
                }
                stack.pop();
                v /= 3;
            }
        }
        System.out.print(stack.isEmpty() ? res : 0);
    }
}