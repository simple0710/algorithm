import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[] creature = new int[N+1];
        while (M-- > 0) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            String b = input[1];
            int c = Integer.parseInt(input[2]);
            if (b.equals("P")) creature[a] = (10 * (c + 1)) + (creature[a] % 10);
            if (b.equals("M")) creature[a] = creature[a] / 10 * 10 + (2 - c);
        }
        int max = 0;
        int min = 0;
        for (int i = 1; i <= N; i++) {
            if (creature[i] / 10 == 1 || creature[i] % 10 == 1) continue;
            max++;
            if (creature[i] == 22) min++;
        }
        System.out.print(min + " " + max);
    }
}