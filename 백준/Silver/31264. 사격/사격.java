import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static long A;
	static List<Integer> arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new ArrayList<>();
		while (st.hasMoreTokens()) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(arr);
		System.out.print(binarySearch());
	}

	public static long binarySearch() {
		long s = 0;
		long e = 10000000000L;
		long res = 0;
		while (s <= e) {
			long mid = (s + e) / 2;
			long shootScore = mid;
			for (int i = 0; i < M; i++) {
				shootScore += binarySearch2(shootScore);
			}
			if (shootScore - mid >= A) {
				e = mid - 1;
				res = mid;
			} else {
				s = mid + 1;
			}
		}
		return res;
	}

	public static int binarySearch2(long shootScore) {
		int s = 0, e = N - 1;
		int res = 0;
		while (s <= e) {
			int mid = (s + e) / 2;
			if (arr.get(mid) <= shootScore) {
				s = mid + 1;
				res = arr.get(mid);
			} else {
				e = mid - 1;
			}
		}
		return res;
	}
}