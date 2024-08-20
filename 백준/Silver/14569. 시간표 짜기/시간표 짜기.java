import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input;
        int N = Integer.parseInt(br.readLine());
        int[][] subjects = new int[N][5];
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            int k = Integer.parseInt(input[0]);
            for (int j = 1; j <= k; j++) {
                int t = Integer.parseInt(input[j]) - 1;
                int day = t / 10;
                int time = t % 10;
                subjects[i][day] |= 1 << time;
            }
        }
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int p = Integer.parseInt(input[0]);
            int[] now = new int[5];
            for (int j = 1; j <= p; j++) {
                int q = Integer.parseInt(input[j]) - 1;
                int day = q / 10;
                int time = q % 10;
                now[day] |= 1 << time;
            }
            int cnt = 0;
            for (int[] sub : subjects) {
                int v = 1;
                for (int j = 0; j <= 4; j++) {
                    if ((sub[j] & now[j]) != sub[j]) {
                        v = 0;
                        break;
                    }
                }
                cnt += v;
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }
}