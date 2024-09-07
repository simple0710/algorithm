import java.io.*;
import java.util.ArrayList;

class Main {
    static int N, K;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        arr = new int[K];
        boolean[] plug = new boolean[101];
        input = br.readLine().split(" ");
        for (int i = 0 ; i < K; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        int plugSize = 0;
        int res = 0;
        for (int i = 0; i < K; i++) {
            int now = arr[i];
            if (plugSize < N && !plug[now]) {
                plug[now] = true;
                plugSize++;
                continue;
            }
            if (!plug[now]) {
                int[] outPlugInfo = new int[]{-1, -1};
                for (int j = 0; j < 101; j++) {
                    if (plug[j]) {
                        int idx = findNumIdx(i, j);
                        if (idx == -1) {
                            outPlugInfo[0] = j;
                            break;
                        } else if (outPlugInfo[1] < idx) {
                            outPlugInfo = new int[] {j, idx};
                        }
                    }
                }
                plug[outPlugInfo[0]] = false;
                plug[now] = true;
                res++;
            }
        }
        System.out.print(res);
    }

    static int findNumIdx(int idx, int num) {
        for (int i = idx+1; i < K; i++) {
            if (arr[i] == num) return i;
        }
        return -1;
    }
}
