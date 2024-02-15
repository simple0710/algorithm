import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[] numsArr, resArr;
	static boolean[] numsPick;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();;
		numsArr = new int[N];
		for (int i = 0; i < N; i++) numsArr[i] = sc.nextInt();
		Arrays.sort(numsArr);
		resArr = new int[M];
		numsPick = new boolean[N];
		back(0);
		System.out.print(sb);
	}
	
	public static void back(int depth) {
		if (depth == M) {
			for (int v : resArr) sb.append(v).append(" ");
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!numsPick[i]) {
				numsPick[i] = true;
				resArr[depth] = numsArr[i]; 
				back(depth + 1);
				numsPick[i] = false;
			}
		}
	}
}