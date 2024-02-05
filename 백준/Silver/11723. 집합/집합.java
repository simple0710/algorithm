import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		long S = 0;
		while (M-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			int x = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) - 1 : 0;
			switch (command) {
			case "add":
				S |= 1 << x;
				break;
			case "remove":
				S &= ~(1 << x);
				break;
			case "check":
				sb.append((S & 1 << x) > 0 ? 1 : 0).append("\n");
				break;
			case "toggle":
				S ^= 1 << x;
				break;
			case "all":
				S = ~(1 << 20);
				break;
			case "empty":
				S = 0;
				break;
			}
		}
		System.out.print(sb);
	}
}