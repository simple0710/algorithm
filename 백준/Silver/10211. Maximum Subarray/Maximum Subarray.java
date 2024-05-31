import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int res = Integer.MIN_VALUE;
            String[] nums = br.readLine().split(" ");
            int[] prefixArr = new int[N+1];
            for (int i = 1; i <= N; i++) {
                prefixArr[i] = prefixArr[i-1] + Integer.parseInt(nums[i-1]);
                for (int j = 0; j < i; j++) {
                    res = Math.max(res, prefixArr[i] - prefixArr[j]);
                }
            }
            System.out.println(res);
        }
    }
}