import java.io.*;

public class Main {
    static int[][] favInfo;
    static int fav, changeFav;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            favInfo = new int[11][5];
            for (int i = 2; i <= 10; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < 5; j++) favInfo[i][j] = Integer.parseInt(input[j]);
            }
            fav = play(new int[]{6, 7, 8, 9, 10});
            changeFav = 10;
            back(0, new int[5], new boolean[5]);
            sb.append(fav > changeFav ? "YES" : "NO").append("\n");
        }
        System.out.print(sb);
    }

    private static void back(int depth, int[] picks, boolean[] visited) {
        if (depth == 5) {
            changeFav = Math.min(changeFav, play(picks));
            return;
        }
        for (int i = 6; i <= 10; i++) {
            if (!visited[i%6]) {
                picks[depth] = i;
                visited[i%6] = true;
                back(depth+1, picks, visited);
                visited[i%6] = false;
            }
        }
    }

    private static int play(int[] myFav) {
        favInfo[1] = myFav;
        int pairCnt = 0;
        int[] pair = new int[11];
        boolean[][] cut = new boolean[6][11];
        boolean[] out = new boolean[11];
        while (pairCnt < 5) {
            for (int g = 6; g <= 10; g++) {
                if (out[g]) continue;
                for (int i = 0; i < 5; i++) {
                    int m = favInfo[g][i];
                    if (!cut[m][g]) {
                        if (pair[m] != 0) {
                            if (indexOf(m, pair[m]) > indexOf(m, g)) {
                                cut[m][pair[m]] = true;
                                out[pair[m]] = false;
                                out[g] = true;
                                pair[m] = g;
                            } else cut[m][g] = true;
                        } else {
                            pair[m] = g;
                            out[g] = true;
                            pairCnt++;
                        }
                        break;
                    }
                }
            }
        }
        return pair[1];
    }

    private static int indexOf(int man, int num) {
        for (int i = 0; i < 5; i++) {
            if (favInfo[man][i] == num) return i;
        }
        return 0;
    }
}