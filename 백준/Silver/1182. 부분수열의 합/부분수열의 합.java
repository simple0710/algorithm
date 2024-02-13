import java.io.*;
import java.util.*;

public class Main {
	static int N, S, res;
	static int[] nums;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
		res = 0;
		back(0, 0, 0);
		System.out.print(res);
	}
	
	public static void back(int depth, int sum, int start) {
		if (depth > 0 && sum == S) res++;
		if (depth == N) return;
		for (int i = start; i < N; i++) back(depth + 1, sum + nums[i], i + 1);
	}
}