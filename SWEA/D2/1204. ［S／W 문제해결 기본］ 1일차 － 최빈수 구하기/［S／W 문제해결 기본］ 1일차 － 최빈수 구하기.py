import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int tc = Integer.parseInt(br.readLine());
            int[] scoreArr = new int[101];
            int maxNum = 0;
            int maxCnt = 0;
            for (String numStr : br.readLine().split(" ")) {
                int num = Integer.parseInt(numStr);
                if (maxCnt <= scoreArr[num]) {
                    maxCnt = scoreArr[num];
                    maxNum = num;
                }
                scoreArr[num]++;
            }
            System.out.println(String.format("#%d %d", tc, maxNum));
        }
    }
}