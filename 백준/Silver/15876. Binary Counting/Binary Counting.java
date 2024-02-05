import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()) - 1;
		long shiftCnt = 0;
		long callNumber = 0;
		long totalCall = 0;
		long answerCnt = 0;
		StringBuilder sb = new StringBuilder();
		while (true) {
			if (callNumber >= (1 << (shiftCnt+1))) shiftCnt++;
			long tmpShiftCnt = shiftCnt;
			while (tmpShiftCnt >= 0) {
				if (totalCall % N == K) {
					answerCnt++;
					sb.append((callNumber & (1 << tmpShiftCnt)) > 0 ? 1 : 0).append(" ");
					if (answerCnt == 5) {
						System.out.print(sb);
						return;
					}
				}
				tmpShiftCnt--;
				totalCall++;
			}
			callNumber++;
		}
		
	}
}