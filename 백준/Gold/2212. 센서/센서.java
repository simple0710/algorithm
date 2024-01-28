import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		if (K >= N) {
			System.out.print(0);
			System.exit(0);
		}
		ArrayList<Integer> sensors = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			sensors.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(sensors);
		ArrayList<Integer> disDiffList = new ArrayList<>();
		for (int i = 1; i < N; i++) {
			disDiffList.add(sensors.get(i) - sensors.get(i-1));
		}
		Collections.sort(disDiffList, Collections.reverseOrder());
		int res = 0;
		for (int i = K-1; i < N-1; i++) {
			res += disDiffList.get(i);
		}
		System.out.print(res);
	}
}
