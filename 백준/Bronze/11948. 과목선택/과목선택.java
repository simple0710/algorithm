import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int res = 0;
        int min = 101;
        for (int i = 0; i < 4; i++) {
            int now = Integer.parseInt(br.readLine());
            res += now;
            min = Math.min(min, now);
        }
        res -= min;
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        res += Math.max(a, b);
        System.out.println(res);
    }
}