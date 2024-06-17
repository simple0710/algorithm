import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        int cnt = 0;
        int res = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '(') {
                if (cnt < 0) {
                    res -= cnt;
                    cnt = 0;
                }
                cnt++;
            } else cnt--;
        }
        System.out.print(res + (cnt < 0 ? -cnt : cnt));
    }
}