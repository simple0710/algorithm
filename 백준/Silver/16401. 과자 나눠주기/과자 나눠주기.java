import java.io.*;
import java.util.*;

public class Main {
	static int M, N;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	M = Integer.parseInt(st.nextToken());
    	N = Integer.parseInt(st.nextToken());
    	int[] arr = new int[N];
    	st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
    	Arrays.sort(arr);
    	System.out.print(binarySearch(arr));
	}
    
	private static int binarySearch(int[] arr) {
		int s = 1;
		int e = 1_000_000_000;
		int res = 0;
		while (s < e) {
			int mid = (s + e) / 2;
			int cnt = 0;
			for (int i = 0; i < N; i++) cnt += arr[i] / mid;
			if (cnt < M) e = mid;
			else {
				res = mid;
				s = mid + 1;
			}
		}
		return res;
	}
}