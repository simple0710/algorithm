import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			char[] str = br.readLine().toCharArray();
			Stack<Character> charListLeft = new Stack<>();
			Stack<Character> charListRight = new Stack<>();
			for (char v : str) {
				if (v == '<') {
					if (!charListLeft.isEmpty()) {
						charListRight.add(charListLeft.pop());
					}
				}
				else if (v == '>') {
					if (!charListRight.isEmpty()) {
						charListLeft.add(charListRight.pop());
					}
				}
				else if (v == '-') {
					if (!charListLeft.isEmpty()) {
						charListLeft.pop();
					}
				}
				else {
					charListLeft.add(v);
				}
			}
			for (int i = 0; i < charListLeft.size(); i++) {
				sb.append(charListLeft.get(i));
			}
			for (int i = charListRight.size()-1; i >= 0; i--) {
				sb.append(charListRight.get(i));
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}