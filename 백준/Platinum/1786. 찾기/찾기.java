import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String t = br.readLine();
		String p = br.readLine();
		
		int[] table = new int[p.length()];
		int idx = 0;
		
		for (int i = 1; i < p.length(); i++) {
			while (idx > 0 && p.charAt(i) != p.charAt(idx)) {
				idx = table[idx-1];
			}
			if (p.charAt(i) == p.charAt(idx)) {
				idx++;
				table[i] = idx;
			}
		}
		
		ArrayList<Integer> res = new ArrayList<>();
		idx = 0;
		for (int i = 0; i < t.length(); i++) {
			while (idx > 0 && t.charAt(i)!= p.charAt(idx)) {
				idx = table[idx-1];
			}
			if (t.charAt(i) == p.charAt(idx)) {
				if (idx == p.length() - 1) {
					res.add(i-idx+1);
					idx = table[idx];
				} else {
					idx+=1;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(res.size()).append("\n");
		for (int now : res) {
			sb.append(now).append("\n");
		}
		System.out.println(sb);
	}
}