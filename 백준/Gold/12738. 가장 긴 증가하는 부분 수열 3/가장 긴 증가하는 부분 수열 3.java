import java.io.*;
import java.util.*;

public class Main {
	static int N, res;
	static int[] sortArr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		res = 0;
		sortArr = new int[N+1];
		Arrays.fill(sortArr, Integer.MAX_VALUE);
		for (int i = 1; i < N+1; i++) {
			binarySearch(Integer.parseInt(st.nextToken()));
		}
		System.out.print(res);
	}

	public static void binarySearch(int find) {
		int s = 0, e = N-1;
		while (s < e) {
			int mid = (s + e) / 2;
			if (find <= sortArr[mid]) e = mid;
			else s = mid + 1;
		}
		res = Math.max(res, 1 + e);
		sortArr[e] = find;
	}
}