import java.io.*;

public class Main {
    static String S, P;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        P = br.readLine();
        int cnt = 0;
        int p = 0;
        while (p < P.length()) {
            int maxIdx = 0;
            cnt++;
            for (int s = 0; s < S.length(); s++) {
                if (P.charAt(p) == S.charAt(s)) {
                    int now = p;
                    for (int k = s; k < S.length(); k++) {
                        if (S.charAt(k) != P.charAt(now)) break;
                        now++;
                        if (now == P.length()) break;
                    }
                    maxIdx = Math.max(maxIdx, now);
                }
            }
            p = maxIdx;
        }
        System.out.print(cnt);
    }
}