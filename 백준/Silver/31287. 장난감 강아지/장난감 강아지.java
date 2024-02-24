import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  =new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int x = 0;
		int y = 0;
		String str = br.readLine();
		String res = "NO";
		for (int i = 0; i < N*Math.min(N, K); i++) {
			if (str.charAt(i%N) == 'U') x++;
			else if (str.charAt(i%N) == 'D') x--;
			else if (str.charAt(i%N) == 'L') y++;
			else y--;
			if (x == 0 && y == 0) {
				res = "YES";
				break;
			}
		}
		System.out.print(res);
	}
}