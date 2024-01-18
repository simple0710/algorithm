import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> arr = new ArrayList<>();
		while (st.hasMoreTokens()) arr.add(Integer.parseInt(st.nextToken()));
		Collections.sort(arr);
		int x = Integer.parseInt(br.readLine());
		int res = 0;
		if (N > 1) {
			int s = 0, e = N-1;
			while (s < e) {
				int sum = arr.get(e) + arr.get(s);
				if (sum == x) res++;
				if (sum >= x) e--;
				else s++;
			}
		}
		System.out.print(res);
	}
}