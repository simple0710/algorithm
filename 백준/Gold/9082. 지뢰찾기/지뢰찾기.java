import java.io.*;

public class Main {
    static int[] dx = {-1, 0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int res = 0;
            String[] nums = br.readLine().split("");
            int[] numArr = new int[N];
            for (int i = 0; i < N; i++) numArr[i] = Integer.parseInt(nums[i]);

            String[] words = br.readLine().split("");
            for (int i = 0; i < N; i++) {
                if (words[i].equals("*")) {
                    res++;
                    for (int d : dx) {
                        int ni = i + d;
                        if (0 <= ni && ni < N) numArr[ni]--;
                    }
                }
            }

            for (int i = 0; i < N; i++){
                if (!words[i].equals("*")) {
                    boolean flag = true;
                    for (int d : dx) {
                        int ni = i + d;
                        if (0 <= ni && ni < N && numArr[ni] == 0) flag = false;
                    }
                    if (flag) {
                        res++;
                        for (int d: dx) {
                            int ni = i + d;
                            if (0 <= ni && ni < N) numArr[ni]--;
                        }
                    }
                }
            }
            System.out.println(res);
        }
    }
}