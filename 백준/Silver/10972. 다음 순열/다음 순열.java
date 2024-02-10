import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] nums;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		nums = new int[N];
		for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
		boolean flag = nextPermutation();
		if (!flag) System.out.print(-1);
		else for (int v : nums) System.out.print(v + " ");
	}
	
	public static boolean nextPermutation() {
		int i = N - 1;
		while (0 < i && nums[i-1] >= nums[i]) --i;
		if (i == 0) return false;
		int j = N - 1;
		while(nums[i-1] >= nums[j]) --j;
		swap(i-1, j);
		int k = N - 1;
		while (i < k) swap(i++, k--);
		return true;
	}
	
	public static void swap(int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}