import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 0;
        while (true) {
            String[] input = br.readLine().split(" ");
            int L = Integer.parseInt(input[0]);
            int P = Integer.parseInt(input[1]);
            int V = Integer.parseInt(input[2]);
            if (L + P + V == 0) break;
            int a = V / P * L;
            int b = Math.min(L, V % P);
            System.out.print(String.format("Case %d: %d\n", ++T, a + b));
        }
    }
}