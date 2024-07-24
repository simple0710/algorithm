import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int a = 1; a <= N-2; a++) {
            for (int b = a + 2; b < N-a; b++) {
                if ((N - a - b) % 2 == 0) cnt++;
            }
        }
        System.out.print(cnt);
    }
}