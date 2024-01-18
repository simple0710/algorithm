import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] cntArr = new int[26];
		String A = br.readLine(), B = br.readLine();
		for (int i = 0; i < A.length(); i++) cntArr[A.charAt(i)-'a']++;
		for (int i = 0; i < B.length(); i++) cntArr[B.charAt(i)-'a']--;
		int res = 0;
		for (int num : cntArr) res += Math.abs(num);
		System.out.println(res);
	}
}