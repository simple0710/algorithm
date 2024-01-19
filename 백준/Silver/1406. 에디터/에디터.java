import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
		String defaultStr = br.readLine();
		for (int i = 0; i < defaultStr.length(); i++) {
			left.add(defaultStr.charAt(i));
		}
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "L":
				if (!left.isEmpty()) {
					right.add(left.pop());
				}
				break;
			case "D":
				if (!right.isEmpty()) {
					left.add(right.pop());
				}
				break;
			case "B":
				if (!left.isEmpty()) {
					left.pop();
				}
				break;
			case "P":
				left.add(st.nextToken().charAt(0));
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!left.isEmpty())
			sb.append(left.pop());
		sb.reverse();
		while (!right.isEmpty()) 
			sb.append(right.pop());
		System.out.print(sb);
	}
}