import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int minL = 10000;
        int minB = 10000;
        int maxT = -10000;
        int maxR = -10000;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            minL = Math.min(minL, x);
            maxR = Math.max(maxR, x);
            minB = Math.min(minB, y);
            maxT = Math.max(maxT, y);
        }
        System.out.println((maxR-minL) * (maxT-minB));
    }
}