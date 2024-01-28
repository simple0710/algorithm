import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<Character> stack = new Stack<>();
		int res = 0;
		for (int i = 0; i < str.length(); i++) {
			char now = str.charAt(i);
			if (now == '(') stack.add(str.charAt(i));
			else {
				if (!stack.isEmpty()) {
					stack.pop();
					if (str.charAt(i - 1) == '(') {
						res += stack.size();
					} else res++;
				}
			}
		}
		System.out.print(res);
	}
}