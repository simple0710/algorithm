import java.io.*;

public class Main {
    static int X, res;
    static int[] arr;
    static String num;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = br.readLine();
        X = Integer.parseInt(num);
        res = Integer.MAX_VALUE;
        arr = new int[10];
        for (int i = 0; i < num.length(); i++) arr[num.charAt(i) - '0']++;
        back(0, 0);
        System.out.print(res == Integer.MAX_VALUE ? 0 : res);
    }

    private static void back(int depth, int mx) {
        if (depth == num.length()) {
            if (mx > X) res = Math.min(res, mx);
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (arr[i] > 0) {
                arr[i]--;
                back(depth+1, mx * 10 + i);
                arr[i]++;
            }
        }
    }
}