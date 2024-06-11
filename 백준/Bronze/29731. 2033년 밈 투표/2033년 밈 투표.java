import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] list = new String[] {
                "Never gonna give you up",
                "Never gonna let you down",
                "Never gonna run around and desert you",
                "Never gonna make you cry",
                "Never gonna say goodbye",
                "Never gonna tell a lie and hurt you",
                "Never gonna stop"
        };
        String res = "No";
        while (N-- > 0) {
            String input = br.readLine();
            if (!Arrays.stream(list).anyMatch(input::equals)) res = "Yes";
        }
        System.out.print(res);
    }
}