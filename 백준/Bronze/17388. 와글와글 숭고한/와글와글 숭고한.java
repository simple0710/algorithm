import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int sum = S + K + Y;
		int min = Math.min(S, K);
		min = Math.min(min, Y);
		if(sum >= 100) {
			System.out.println("OK");
		}else {
			if(min == S) {
				System.out.println("Soongsil");
			}else if(min == K) {
				System.out.println("Korea");
			}else {
				System.out.println("Hanyang");
			}
		}
	}
}