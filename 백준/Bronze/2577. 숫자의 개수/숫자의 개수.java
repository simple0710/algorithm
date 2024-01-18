import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 1;
		for (int i = 0; i < 3; i++) {
			sum *= Integer.parseInt(br.readLine());
		}
		int[] cntArr = new int[10];
		while (sum > 0) {
			cntArr[sum % 10]++;
			sum /= 10;
		}
		for (int i = 0; i < cntArr.length; i++) {
			System.out.println(cntArr[i]);
		}
	}
}