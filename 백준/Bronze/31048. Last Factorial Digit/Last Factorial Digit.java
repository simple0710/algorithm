import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            int v = Integer.parseInt(br.readLine());
            int res = 1;
            while (v > 0) res *= v--;
            System.out.println(res%10);
        }
    }
}