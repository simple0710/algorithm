import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            String[] A = br.readLine().split(" ");
            String[] B = br.readLine().split(" ");
            System.out.println(String.format("#%d %d", t, N >= M ? search(A, B) : search(B, A)));
        }
    }
    public static int search(String[] x, String[] y) {
        int maxSum = 0;
        for (int i = 0; i < x.length - y.length + 1; i++) {
            int checkSum = 0;
            for (int j = 0; j < y.length; j++) {
                checkSum += Integer.parseInt(x[i+j]) * Integer.parseInt(y[j]);
            }
            maxSum = Math.max(maxSum, checkSum);
        }
        return maxSum;
    }
}