import java.io.*;
import java.util.*;

public class Main {
	static long A, C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A =  Long.parseLong(st.nextToken());
		long B =  Long.parseLong(st.nextToken());
		C =  Long.parseLong(st.nextToken());
		System.out.print(recur(B)); 
	}
	
	public static long recur(Long B) {
		if (B == 1) return A % C;
		long nowLongNum = getLongPow(recur(B/2));
		if (B % 2 == 0) return nowLongNum;
		return (nowLongNum * A) % C;
	}
	
	public static long getLongPow(long Num) {
		return (Num * Num) % C;
	}
}