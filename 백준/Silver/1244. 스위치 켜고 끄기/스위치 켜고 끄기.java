import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] switchs = new int[N];
		for (int i = 0; i < N; i++) {
			 switchs[i] = Integer.parseInt(st.nextToken());
		}
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken()) - 1;
			if (gender == 1) {
				for (int i = num; i < N; i+=num+1) switchs[i] = 1 - switchs[i];
			} else {
				int left = num - 1;
				int right = num + 1;
				switchs[num] = 1 - switchs[num];
				while (0 <= left && right < N && switchs[left] == switchs[right]) {
					switchs[left] = 1 - switchs[left];
					switchs[right] = 1 - switchs[right];
					left--;
					right++;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(switchs[i-1]).append(" ");
			if (i % 20 == 0) sb.append("\n");
		}
		System.out.print(sb);
	}
}