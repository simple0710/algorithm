import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] result = solve(N);
            for (int i : result) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static int[] solve(int N) {
        int[] buttons = new int[5]; // [ADDH, ADDT, MINT, ADDO, MINO]

        buttons[0] = N / 60;
        N %= 60;

        if (N <= 35) {
            buttons[1] = N / 10;
            N %= 10;
            if (N <= 5) {
                buttons[3] = N;
            } else {
                buttons[1]++;
                buttons[4] = 10 - N;
            }
        } else {
            buttons[0]++;
            buttons[2] = (60 - N) / 10;
            N = (60 - N) % 10;
            if (N == 0) {
                // Do nothing
            } else if (N <= 5) {
                buttons[4] = N;
            } else {
                buttons[2]++;
                buttons[3] = 10 - N;
            }
        }

        return buttons;
    }
}