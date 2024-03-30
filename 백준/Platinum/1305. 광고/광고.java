import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int[] table = new int[str.length()];
        int idx = 0;
        for (int i = 1; i < str.length(); i++) {
        	while (idx > 0 && str.charAt(i) != str.charAt(idx)) {
        		idx = table[idx-1];
        	}
        	if (str.charAt(i) == str.charAt(idx)) {
        		idx++;
        		table[i] = idx;
        	}
        }
        System.out.println(N-table[N-1]);
    }
}