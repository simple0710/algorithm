import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int res = 0;
            for (String numStr : br.readLine().split(" ")) {
                int num = Integer.parseInt(numStr);
                if ((num % 2) == 1) res += num;
            }
            System.out.println(String.format("#%d %d", t, res));
        }
    }
}