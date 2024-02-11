import java.io.*;
import java.util.*;

public class Main {
	static final long MAX = 3000000001L;
	static int N;
	static long minSum;
	static long[] data, resArr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		data = new long[N];
		for (int i = 0; i < N; i++) data[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(data);
		minSum = MAX;
		resArr = new long[3];
		for (int i = 0; i < N - 2; i++) twoPointer(i);
		Arrays.sort(resArr);
		for (long v : resArr) System.out.print(v + " ");
	}
	
	public static void twoPointer(int firstIdx) {
		int s = firstIdx + 1, e = N - 1;
		while (s < e) {
			long sum = data[s] + data[e] + data[firstIdx];
			if (Math.abs(sum) <= minSum) {
				minSum = Math.abs(sum);
				resArr[0] = data[firstIdx];
				resArr[1] = data[s];
				resArr[2] = data[e];
			}
			if (sum > 0) e--;
			else s++;
		}
	}
}