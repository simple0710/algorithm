import java.io.*;
import java.util.*;

public class Main {
	static int[] day = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] prefixDay = new int[13];
		ArrayList<int[]> data = new ArrayList<>();
		for (int i = 1; i <= 12; i++) prefixDay[i] = prefixDay[i-1] + day[i];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sm = Integer.parseInt(st.nextToken());
			int sd = Integer.parseInt(st.nextToken());
			int em = Integer.parseInt(st.nextToken());
			int ed = Integer.parseInt(st.nextToken());
			int nowStart = prefixDay[sm-1] + sd;
			int nowEnd = prefixDay[em-1] + ed;
			data.add(new int[]{nowStart, nowEnd});
		}
		Collections.sort(data, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});
		int myEnd = 0;
		int nextEnd = 0;
		int res = 0;
		for (int i = 0; i < N; i++) {
			int[] now = data.get(i);
			if (prefixDay[2] + 1 >= now[0]) {
				myEnd =  Math.max(myEnd, now[1]);
				nextEnd = myEnd;
				res = 1;
				if (myEnd > prefixDay[11]) {
					res = 0;
					break;
				}
			} else if (now[0] <= myEnd) {
				nextEnd = Math.max(nextEnd, now[1]);
			} else if (myEnd <= now[0]) {
				if (nextEnd < now[0]) break;
				myEnd = nextEnd;
				nextEnd = now[1];
				res++;
			}
			if (nextEnd > prefixDay[11]) break;
		}
		System.out.print(nextEnd > prefixDay[11] ? res + 1 : 0);
	}
}