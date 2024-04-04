import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int N, K;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		System.out.print(twoPointer());
	}
	private static int twoPointer() {
		int k = 0;
		int s = 0;
		int res = 0;
		for (int e = 0; e < N; e++) {
			if (arr[e] % 2 == 1) k++;
			while (k > K) if (arr[s++] % 2 == 1) k--;
			res = Math.max(res, e - s - k + 1);
		}
		return res;
	}
}