import java.io.*;
import java.util.*;

public class Main {
	static int res, r, c;
	static int[] dx = new int[]{0, 0, 1, 1}, dy = new int[]{0, 1, 0, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		recur(N, 0, 0);
		System.out.print(res);
	}
	
	public static void recur(int nowN, int nowX, int nowY) {
		if (nowN == 1) return;
		int nextN = nowN / 2;
		for (int i = 0; i < 4; i++) {
			int nx = nowX + dx[i] * nextN;
			int ny = nowY + dy[i] * nextN;
			if (r < nx + nextN && c < ny + nextN) {
				recur(nextN, nx, ny);
				break;
			}
			res += nextN * nextN;
		}
	}
}