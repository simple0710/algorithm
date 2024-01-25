import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			char[] command = br.readLine().toCharArray();
			int N = Integer.parseInt(br.readLine());
			String NumsStr = br.readLine();
			String[] arr = NumsStr.substring(1, NumsStr.length() - 1).split(",");
			
			Deque<String> q = new LinkedList<>();
			for (String v : arr) q.add(v);
			if (N == 0) q.clear();
			boolean flag = true;
			boolean resFlag = true;
			for (char v : command) {
				if (v == 'D') {
					if (q.isEmpty()) {
						resFlag = false;
						break;
					}
					if (flag) q.poll();
					else q.pollLast();
					N--;
				} else {
					flag = !flag;
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			if (N > 0) {
				while (!q.isEmpty()) sb.append(flag ? q.poll() : q.pollLast()).append(",");
				sb.deleteCharAt(sb.length()-1);
			}
			sb.append("]");
			System.out.println(resFlag ? sb : "error");
		}
	}
}