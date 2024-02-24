import java.io.*;

public class Main {
	static int N;
	static long res;
	static String[] str;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		str = br.readLine().split("");
		res = -Integer.MAX_VALUE;
		back(0, Integer.parseInt(str[0]));
		System.out.print(res);
	}
	
	public static void back(int depth, long sum) {
		if (depth >= N/2) {
			res = Math.max(res, sum);
			return;
		}
		int now = 2 * depth;
		long a = Long.parseLong(str[now + 2]);
		back(depth+1, cal(sum, a, str[now+1]));
		if (now + 4 < N) {
			long b = Long.parseLong(str[now + 4]);
			back(depth+2, cal(sum, cal(a, b, str[now+3]), str[now+1]));
		}
		
	}
	
	public static long cal(long a, long b, String c) {
		if (c.equals("+")) return a + b;
		else if (c.equals("-")) return a - b;
		return a * b;
	}
}