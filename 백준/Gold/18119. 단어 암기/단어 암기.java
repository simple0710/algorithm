import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        boolean[][] wordCheck = new boolean[N][26];
        int[] forgotCheck = new int[N];
        boolean[] knowCheck = new boolean[N];
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            for (int j = 0; j < word.length(); j++) wordCheck[i][word.charAt(j) - 'a'] = true;
            knowCheck[i] = true;
        }

        int res = N;
        while (M-- > 0) {
            input = br.readLine().split(" ");
            int command = Integer.parseInt(input[0]);
            char alpha = input[1].charAt(0);
            if (command == 1) {
                for (int i = 0; i < N; i++) {
                    if (wordCheck[i][alpha - 'a']) {
                        forgotCheck[i]++;
                        if (knowCheck[i]) {
                            knowCheck[i] = false;
                            res--;
                        }
                    }
                }
            } else {
                for (int i = 0; i < N; i++) {
                    if (knowCheck[i]) continue;
                    if (wordCheck[i][alpha - 'a']) {
                        if (--forgotCheck[i] == 0) {
                            knowCheck[i] = true;
                            res++;
                        }
                    }
                }
            }
            sb.append(res).append("\n");
        }
        System.out.print(sb);
    }
}