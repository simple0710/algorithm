import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (N-- > 0) {
			String[] str = br.readLine().split(" ");
			int X = Integer.parseInt(str[0]);
			int Y = Integer.parseInt(str[1]);
			sb.append(X < Y ? "NO BRAINS" : "MMM BRAINS").append("\n");
		}
		System.out.print(sb);
	}
}