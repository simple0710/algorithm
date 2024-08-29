import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String binaryString = br.readLine();
        BigInteger binaryNum = new BigInteger(binaryString, 2);
        String octalNum = binaryNum.toString(8);
        System.out.print(octalNum);
    }
}