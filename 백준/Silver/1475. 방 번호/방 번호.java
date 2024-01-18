import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nums = br.readLine().split("");
		int[] numArr = new int[10];
		for (String v : nums) {
			int now = Integer.parseInt(v);
			if (now == 6 || now == 9) {
				if (numArr[6] >= numArr[9]) numArr[9]++;
				else numArr[6]++;
			}
			else numArr[now]++;
		}
		int res = 0;
		for (int v : numArr) res = Math.max(res, v);
		System.out.print(res);
	}
}