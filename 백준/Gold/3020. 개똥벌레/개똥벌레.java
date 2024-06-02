import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int H = Integer.parseInt(input[1]);

        int[] bottom = new int[H+2];
        int[] top = new int[H+2];
        for (int i = 0; i < N / 2; i++) {
            bottom[Integer.parseInt(br.readLine())]++;
            top[H-Integer.parseInt(br.readLine()) + 1]++;
        }
        for (int i = 1; i <= H; i++) {
            bottom[i] += bottom[i-1];
            top[H-i] += top[H-i+1];
        }
        int min = N;
        int cnt = 0;
        for (int i = 1; i <= H; i++) {
            int value = (bottom[H] - bottom[i-1] + top[1] - top[i+1]);
            if (value < min) {
                min = value;
                cnt = 1;
            } else if (value == min) cnt++;
        }
        System.out.print(min + " " + cnt);
    }
}