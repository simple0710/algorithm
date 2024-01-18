import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] aArr = new int[26];
			int[] bArr = new int[26];
			String A = st.nextToken();
			String B = st.nextToken();
			if (A.length() == B.length()) {
				for (int j = 0; j < A.length(); j++) {
					aArr[A.charAt(j)-'a']++;
					bArr[B.charAt(j)-'a']++;
				}
				System.out.println(Arrays.equals(aArr, bArr) ? "Possible" : "Impossible");
			}
			else System.out.println("Impossible");
		}
	}
}