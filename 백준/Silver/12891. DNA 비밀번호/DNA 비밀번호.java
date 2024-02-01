import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		String[] strArr = br.readLine().split("");
		String[] needStr = new String[] {"A", "C", "G", "T"};
		int[][] passCntArr = new int[S+1][4];
		for (int i = 1; i < S+1; i++) {
			for (int j = 0; j < 4; j++) {
				passCntArr[i][j] = passCntArr[i-1][j] + (strArr[i-1].equals(needStr[j]) ? 1 : 0);
			}
		}
		st = new StringTokenizer(br.readLine());
		int[] passMaxCntArr = new int[4];
		for (int i = 0; i < 4; i++) passMaxCntArr[i] = Integer.parseInt(st.nextToken());
		int res = 0;
		for (int i = P; i < S+1; i++) {
			int cnt = 1;
			for (int j = 0; j < 4; j++) {
				if (passCntArr[i][j] - passCntArr[i-P][j] < passMaxCntArr[j]) cnt = 0;
			}
			res += cnt;
		}
		System.out.print(res);
	}
}