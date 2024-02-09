import java.io.*;
import java.util.*;

public class Main {
	static final int MAX = 1000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] pickNum = new int[N];
		int[] scoreBoard = new int[MAX+1];
		boolean[] isPickNum = new boolean[MAX+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());
			pickNum[i] = now;
			isPickNum[now] = true;
		}
		for (int i = 0; i < N; i++) {
			int now = pickNum[i];
			for (int j = now * 2; j <= MAX; j+=now) {
				if (isPickNum[j]) {
					scoreBoard[now]++;
					scoreBoard[j]--;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int v : pickNum) sb.append(scoreBoard[v]).append(" ");
		System.out.print(sb);
	}
}