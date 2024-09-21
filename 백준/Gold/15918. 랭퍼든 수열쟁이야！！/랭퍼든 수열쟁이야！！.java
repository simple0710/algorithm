import java.io.*;
import java.util.*;

class Main {
    static int N, X, Y, res;
    static int[] sequence;
    static boolean[] used;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        X = Integer.parseInt(input[1]);
        Y = Integer.parseInt(input[2]);

        sequence = new int[2 * N];
        used = new boolean[N + 1];

        backtrack(0);

        System.out.print(res);
    }

    private static void backtrack(int index) {
        if (index == 2 * N) {
            if (sequence[X - 1] == sequence[Y - 1]) {
                res++;
            }
            return;
        }

        if (sequence[index] != 0) {
            backtrack(index + 1);
            return;
        }

        for (int num = 1; num <= N; num++) {
            if (!used[num] && index + num + 1 < 2 * N && sequence[index + num + 1] == 0) {
                used[num] = true;
                sequence[index] = num;
                sequence[index + num + 1] = num;
                backtrack(index + 1);
                used[num] = false;
                sequence[index] = 0;
                sequence[index + num + 1] = 0;
            }
        }
    }
}