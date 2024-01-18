import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[26];
		String str = br.readLine();
		for (int i = 0; i < str.length(); i++) arr[str.charAt(i)-'a'] += 1;
		for (int v : arr) System.out.print(v + " ");
	}
}