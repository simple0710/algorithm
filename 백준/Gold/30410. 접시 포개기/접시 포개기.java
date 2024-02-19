import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int res = 0;
		int oneCnt = 0;
		int twoCnt = 0;
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());
			if (now == 1) oneCnt++;
			else {
				if (oneCnt % 2 == 0) {
					twoCnt += oneCnt / 2;
				}
				else {
					res = Math.max(res, getNum(twoCnt + oneCnt / 2));
					twoCnt = oneCnt / 2;
				}
				oneCnt = 0;
				twoCnt++;
			}
		}
		res = Math.max(res, getNum(twoCnt + oneCnt / 2));
		System.out.print(res);
	}
	
	public static int getNum(int twoCnt) {
		int check = 1;
		while (twoCnt > 0) {
			twoCnt /= 2;
			check *= 2;
		}
		return check;
	}
}