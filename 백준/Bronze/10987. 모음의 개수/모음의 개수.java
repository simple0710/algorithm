import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split("");
		int cnt = 0;
		for (String s : str) {
			if ("aeiou".contains(s)) cnt++;
		}
		System.out.print(cnt);
	}
}