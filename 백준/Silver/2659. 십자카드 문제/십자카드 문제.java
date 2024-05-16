import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] checkNums = new boolean[10000];
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    for (int l = 1; l <= 9; l++) {
                        int num = getTimeNumbers(i, j, k, l);
                        if (!checkNums[num]) checkNums[num] = true;
                    }
                }
            }
        }
        String[] input = br.readLine().split(" ");
        int[] numArr = new int[4];
        for (int i = 0; i < 4; i++) numArr[i] = Integer.parseInt(input[i]);
        int minNum = getTimeNumbers(numArr);
        int res = 0;
        for (int i = 1111; i <= minNum; i++) {
            if (checkNums[i]) res++;
        }
        System.out.println(res);
    }

    public static int getTimeNumbers(int... numArr) {
        int now = 9999;
        for (int i = 0; i < 4; i++) {
            int check = 0;
            for (int j = i; j < i+4; j++) check += numArr[j%4] * (int) Math.pow(10, i+3-j);
            now = Math.min(now, check);
        }
        return now;
    }
}