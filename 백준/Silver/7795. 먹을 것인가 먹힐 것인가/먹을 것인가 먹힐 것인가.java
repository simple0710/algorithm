import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			Integer[] aArr = getSortArr(N, new StringTokenizer(br.readLine()));
			Integer[] bArr = getSortArr(M, new StringTokenizer(br.readLine()));
			int res = 0;
			int s = 0;
			for (int i = 0; i < N; i++) {
				while (s < M) {
					if (aArr[i] <= bArr[s]) break;
					res += N-i;
					s++;
				}
			}
			System.out.println(res);
		}
	}
	
	static Integer[] getSortArr(int length, StringTokenizer st) {
		Integer[] arr = new Integer[length];
		for (int i = 0; i < length; i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		return arr;
	}
}