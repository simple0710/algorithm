import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int[] numCnt = new int[100001];
		String res = "YES";
		int limit = N % 2 == 0 ?  N / 2 : N / 2 + 1;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			numCnt[arr[i]]++;
			if (numCnt[arr[i]] > limit) res = "NO";
		}
		System.out.print(res);
	}
}