import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			StringBuilder sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				sb.append(st.nextToken());
				System.out.println(sb.reverse());
			}
		}
    }
}