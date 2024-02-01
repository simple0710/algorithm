import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		long res = 0L;
		while (N > 0) {
			long cnt = 0L;
			long num = 1L;
			while (N >= num << 1) {
				num <<= 1;
				cnt++;
			}
			N -= num;
			res += newPow(cnt);
		}
		System.out.print(res);
	}
	public static Long newPow(Long tempCnt) {
		long newV = 1L;
		for (int i = 0; i < tempCnt; i++) newV *= 3;
		return newV;
	}
}