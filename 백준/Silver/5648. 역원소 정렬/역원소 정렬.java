import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<Long> list = new ArrayList<>();
        int i = 0;
        while (true) {
            while (st.hasMoreTokens()) {
                StringBuffer sbf = new StringBuffer(st.nextToken());
                list.add(Long.parseLong(sbf.reverse().toString()));
                i++;
            }
            if (i >= N) break;
            st = new StringTokenizer(br.readLine());
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (long num : list) sb.append(num).append("\n");
        System.out.print(sb);
    }
}