import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) arr[i] = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		int idx = 0;
		boolean flag = false;
		while (idx < N) {
			if (arr[idx].equals("KBS2")) flag = true;
			if (arr[idx].equals("KBS1")) break;
			sb.append("1");
			idx++;
		}
		while (idx-- >=  1) {
			sb.append("4");
		}
		idx = 0;
		if(flag) sb.append("1");
		while (idx < N) {
			if (arr[idx].equals("KBS2")) break;
			sb.append("1");
			idx++;
		}
		while (idx-- > 1) {
			sb.append("4");
		}
		if (flag) sb.append("4");
		System.out.print(sb);
	}
}