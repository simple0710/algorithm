import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		LinkedHashSet<String> set = new LinkedHashSet<>();
		for (int i = 0; i < L; i++) {
			String now = br.readLine();
			if (set.contains(now)) set.remove(now);
			set.add(now);
		}
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		for (String num : set) {
			sb.append(num).append("\n");
			if (++cnt == K) break;
		}
		System.out.print(sb);
	}
}