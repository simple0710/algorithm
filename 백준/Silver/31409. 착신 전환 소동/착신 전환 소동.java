import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (i == arr[i]) {
				cnt++;
				arr[i] = i == N ? 1 : i + 1; 
			}
		}
		System.out.println(cnt);
		for (int i = 1; i <= N; i++) System.out.print(arr[i] + " ");
	}
}