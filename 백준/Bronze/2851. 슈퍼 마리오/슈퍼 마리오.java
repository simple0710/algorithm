import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int check = 0;
        boolean flag = false;
        for (int i = 0; i < 10; i++) {
            int n = Integer.parseInt(br.readLine());
            if (flag) continue;
            if (check + n <= 100) {
                if (check < check + n) check += n;
                else flag = true;
            } else {
                if (100 - check >= check + n - 100) check += n;
                else flag = true;
            }
        }
        System.out.print(check);
    }
}