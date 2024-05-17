import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input1 = Integer.parseInt(br.readLine());
        int input2 = Integer.parseInt(br.readLine());
        System.out.println(input2 + (input2 -  input1));
    }
}