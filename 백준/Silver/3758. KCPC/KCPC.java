import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input;
        int T, N, K, teamId, M, I, J, S;
        int[][] submitScore;
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            K = Integer.parseInt(input[1]);
            teamId = Integer.parseInt(input[2]);
            M = Integer.parseInt(input[3]);
            int[] submitCnt = new int[N+1];
            int[] submitTime = new int[N+1];
            submitScore = new int[N+1][K+1];
            int[] totalScore = new int[N+1];
            for (int time = 1; time <= M; time++) {
                input = br.readLine().split(" ");
                I = Integer.parseInt(input[0]);
                J = Integer.parseInt(input[1]);
                S = Integer.parseInt(input[2]);
                if (submitScore[I][J] < S) {
                    totalScore[I] += S - submitScore[I][J];
                    submitScore[I][J] = S;
                }
                submitCnt[I]++;
                submitTime[I] = time;
            }
            Integer[] arr = new Integer[N+1];
            for (int i = 0; i <= N; i++) arr[i] = i;
            totalScore[0] = Integer.MAX_VALUE;
            Arrays.sort(arr, new Comparator<Integer>() {
               @Override
               public int compare(Integer o1, Integer o2) {
                   if (totalScore[o1] != totalScore[o2]) return Integer.compare(totalScore[o2], totalScore[o1]);
                   else if (submitCnt[o1] != submitCnt[o2]) return Integer.compare(submitCnt[o1], submitCnt[o2]);
                   return Integer.compare(submitTime[o1], submitTime[o2]);
               }
            });
            for (int i = 1; i <= N; i++) {
                if (arr[i] == teamId) {
                    sb.append(i).append("\n");
                    break;
                }
            }
        }
        System.out.print(sb);
    }
}