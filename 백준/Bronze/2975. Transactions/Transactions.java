import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while (!(input = br.readLine()).equals("0 W 0")) {
            String[] newInput = input.split(" ");
            int a = Integer.parseInt(newInput[0]);
            String how = newInput[1];
            int num = Integer.parseInt(newInput[2]);
            int sum = a + (how.equals("W") ? -num : num);
            if (how.equals("W") && sum < -200) System.out.println("Not allowed");
            else System.out.println(sum);
        }
    }
}