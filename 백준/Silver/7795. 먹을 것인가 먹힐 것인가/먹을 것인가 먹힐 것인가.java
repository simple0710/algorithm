import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			ArrayList<Integer> aList = getSortList(new StringTokenizer(br.readLine()));
			ArrayList<Integer> bList = getSortList(new StringTokenizer(br.readLine()));
			int res = 0;
			int s = 0;
			for (int i = 0; i < N; i++) {
				while (s < M) {
					if (aList.get(i) <= bList.get(s)) break;
					res += N-i;
					s++;
				}
			}
			System.out.println(res);
		}
	}
	
	static ArrayList<Integer> getSortList(StringTokenizer st) {
		ArrayList<Integer> list = new ArrayList<>();
		while (st.hasMoreTokens()) list.add(Integer.parseInt(st.nextToken()));
		Collections.sort(list);
		return list;
	}
}