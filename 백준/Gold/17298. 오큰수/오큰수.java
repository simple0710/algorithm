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
        int[] numArr = new int[N];
        int[] resArr = new int[N];
        for (int i = 0; i < N; i++) {
            int v = Integer.parseInt(st.nextToken());
            resArr[i] = -1;
            while (!stack.isEmpty() && numArr[stack.peek()] < v) resArr[stack.pop()] = v;
            stack.add(i);
            numArr[i] = v;
        }
        StringBuilder sb = new StringBuilder();
        for (int num : resArr) sb.append(num).append(" ");
        System.out.println(sb);
    }
}