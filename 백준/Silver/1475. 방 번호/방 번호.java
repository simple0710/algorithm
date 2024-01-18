import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nums = br.readLine().split("");
		int[] numArr = new int[10];
		int res = 0;
		for (String v : nums) {
			int now = Integer.parseInt(v);
			if (now == 6 || now == 9) {
				if (numArr[6] >= numArr[9]) now = 9;
				else now = 6;
			}
			numArr[now]++;
			res = Math.max(res, numArr[now]);
		}
		System.out.print(res);
	}
}