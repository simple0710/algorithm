import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int W, S, res;
        int[] wArr, sArr;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        W = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);
        String w = br.readLine();
        String s = br.readLine();
        wArr = new int[52];
        sArr = new int[52];
        res = 0;
        int l = 0;
        for (char c : w.toCharArray()) putWord(wArr, c, 1);
        for (int r = 0; r < S; r++) {
            putWord(sArr, s.charAt(r), 1);
            if (r >= W-1) {
                if (Arrays.equals(wArr, sArr)) res++;
                putWord(sArr, s.charAt(l), -1);
                l++;
            }
        }
        System.out.print(res);
    }

    private static void putWord(int[] arr, char word, int val) {
        if ('a' <= word) arr[word-'a'+26] += val;
        else arr[word-'A'] += val;
    }
}