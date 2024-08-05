import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int L = Integer.parseInt(input[1]);
        int D = Integer.parseInt(input[2]);
        boolean[] music =  new boolean[N*L+5 * (N-1)];
        for (int i = 0; i < N; i++) {
            int S = (L+5) * i;
            for (int j = S; j < S + L; j++) music[j] = true;
        }
        int time = 0;
        while (time < music.length && music[time]) time += D;
        System.out.print(time);
    }
}