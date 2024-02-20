import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[] nums, pick;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(nums);
		pick = new int[M];
		back(0);
		System.out.print(sb);
	}
	
	public static void back(int depth) {
		if (depth == M) {
			for (int v : pick) sb.append(v + " ");
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			pick[depth] = nums[i];
			back(depth+1);
		}
	}
}