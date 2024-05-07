import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int D = Integer.parseInt(br.readLine());
		String res = "Before";
		if (M == 2) {
			if (D == 18) res = "Special";
			else if (D > 18)  res = "After";
		} else if (M >= 3) res = "After"; 
		System.out.print(res);
	}
}