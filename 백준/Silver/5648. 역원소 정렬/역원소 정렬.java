import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Long> sortList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sortList = new ArrayList<>();
		int N = Integer.parseInt(st.nextToken());
		N -= getNum(st);
		while ((N -= getNum(st = new StringTokenizer(br.readLine()))) > 0);
		Collections.sort(sortList);
		StringBuilder sb = new StringBuilder();
		for (long now : sortList) sb.append(now).append("\n");
		System.out.print(sb);
	}
	public static int getNum(StringTokenizer st) {
		int cnt = 0;
		while (st.hasMoreTokens()) {
			StringBuilder sb = new StringBuilder();
			sb.append(st.nextToken());
			sortList.add(Long.parseLong(sb.reverse().toString()));
			cnt++;
		}
		return cnt;
	}
}