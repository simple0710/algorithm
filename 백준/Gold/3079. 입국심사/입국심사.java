import java.io.*;
import java.util.*;

public class Main {
	static long N, M;
	static ArrayList<Long> list;

	public static long binarySearch() {
		long s = 0;
		long e = Long.MAX_VALUE;
		long res = e;
		while (s <= e) {
			long mid = (s + e) / 2;
			long people = M;
			for (int i = 0; i < N; i++) {
				if (people <= 0) break;
				people -= mid / list.get(i);
			}
			if (people <= 0) {
				res = Math.min(res,  mid);
				e = mid - 1;
			}
			else s = mid + 1;
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		M = Long.parseLong(st.nextToken());
		for (int i = 0; i < N; i++) {
			list.add(Long.parseLong(br.readLine()));
		}
		Collections.sort(list);
		System.out.print(binarySearch());
	}
}