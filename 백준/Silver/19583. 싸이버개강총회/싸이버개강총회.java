import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> map = new HashMap<>();
		String[] input = br.readLine().split(" ");
		String[] start = input[0].split(":");
		int S = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
		String[] end = input[1].split(":");
		int E = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);
		String[] endQ = input[2].split(":");
		int Q = Integer.parseInt(endQ[0]) * 60 + Integer.parseInt(endQ[1]);
		int res = 0;
		String newInput;
		while ((newInput = br.readLine()) != null) {
			input = newInput.split(" "); 
			String[] now = input[0].split(":");
			String name = input[1];
			int N = Integer.parseInt(now[0]) * 60 + Integer.parseInt(now[1]);
			if (map.containsKey(name) && E <= N && N <= Q) {
				if (map.get(name) == 0) {
					map.put(name, 1);
					res++;
				}
			}
			else if (N <= S) map.put(name, 0);
		}
		System.out.print(res);
	}
}