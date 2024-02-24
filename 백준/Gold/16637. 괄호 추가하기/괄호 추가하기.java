import java.io.*;

public class Main {
	static int N;
	static int res;
	static String[] str;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		str = br.readLine().split("");
		res = -Integer.MAX_VALUE;
		back(0, Integer.parseInt(str[0]));
		System.out.print(res);
	}
	
	public static void back(int depth, int sum) {
		if (depth >= N/2) {
			res = Math.max(res, sum);
			return;
		}
		int now = 2 * depth;
		int a = Integer.parseInt(str[now + 2]);
		back(depth+1, cal(sum, a, str[now+1]));
		if (now + 4 < N) {
			int b = Integer.parseInt(str[now + 4]);
			back(depth+2, cal(sum, cal(a, b, str[now+3]), str[now+1]));
		}
	}
	
	public static int cal(int a, int b, String c) {
		if (c.equals("+")) return a + b;
		else if (c.equals("-")) return a - b;
		return a * b;
	}
}