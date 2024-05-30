import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        BigDecimal A = new BigDecimal(input[0]);
        int B = Integer.parseInt(input[1]);
        System.out.print(A.pow(B).toPlainString());
    }
}