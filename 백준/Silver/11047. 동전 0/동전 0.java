import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		int N = Integer.parseInt(st[0]);
		int K = Integer.parseInt(st[1]);
		int[] arr = new int[N];
		int res = 0;
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
		for (int i = N-1; i >= 0; i--) {
			res += K / arr[i];
			K %= arr[i];
		}
		System.out.print(res);
	}
}