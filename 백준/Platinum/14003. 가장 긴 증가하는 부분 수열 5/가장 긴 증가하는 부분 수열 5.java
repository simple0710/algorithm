import java.io.*;
import java.util.*;

public class Main {
	static int N, res;
	static int[] nums, idxArr;
	static ArrayList<Integer> numList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
		numList = new ArrayList<>();
		numList.add(-1_000_000_001);
		idxArr = new int[N];
		for (int i = 0; i < N; i++) binarySearch(nums[i], i);
		Stack<Integer> stack = new Stack<>();
		int idx = numList.size() - 1;
		for (int i = N - 1; i >= 0; i--) {
			if (idxArr[i] == idx) {
				idx--;
				stack.add(nums[i]);
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(res).append("\n");
		while (!stack.isEmpty()) sb.append(stack.pop()).append(" ");
		System.out.print(sb);
	}
	
	public static void binarySearch(int num, int idx) {
		int s = 0, e = numList.size() - 1;
		if (numList.get(e) < num) {
			numList.add(num);
			idxArr[idx] = numList.size() - 1;
		}
		else {
			while (s < e) {
				int mid = (s + e) / 2;
				if (num > numList.get(mid)) s = mid + 1;
				else e = mid;
			}
			numList.set(e, num);
			idxArr[idx] = e;
		}
		res = Math.max(res, numList.size() - 1);
	}
}