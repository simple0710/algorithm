import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        String word = br.readLine();
        Stack<Character> stack = new Stack<>();
        int[] arr = new int[string.length()+1];
        int now = 0;
        for (char i : string.toCharArray()) {
            stack.add(i);
            if (i != word.charAt(now)) now = 0;
            if (i == word.charAt(now)) now++;
            if (now == word.length()) {
                while (now-- > 0) stack.pop();
                now = arr[stack.size()];
            }
            arr[stack.size()] = now;
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = stack.isEmpty();
        while (!stack.isEmpty()) sb.append(stack.pop());
        System.out.println(flag ? "FRULA" : sb.reverse());
    }
}