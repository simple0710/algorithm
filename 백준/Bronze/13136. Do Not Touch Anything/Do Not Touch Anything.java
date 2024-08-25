import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long R = Integer.parseInt(input[0]);
        long C = Integer.parseInt(input[1]);
        double N = Integer.parseInt(input[2]);
        System.out.print((long) (Math.ceil(R / N) * Math.ceil(C / N)));
    }
}