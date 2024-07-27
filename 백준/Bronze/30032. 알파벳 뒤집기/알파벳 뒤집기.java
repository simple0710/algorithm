import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int D = Integer.parseInt(input[1]);
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            String word = br.readLine();
            for (int i = 0; i < word.length(); i++) {
                char now = word.charAt(i);
                char ch;
                if (D == 1) {
                    if (now == 'd') ch = 'q';
                    else if (now == 'b') ch = 'p';
                    else if (now == 'p') ch = 'b';
                    else ch = 'd';
                } else {
                    if (now == 'd') ch = 'b';
                    else if (now == 'b') ch = 'd';
                    else if (now == 'p') ch = 'q';
                    else ch = 'p';
                }
                sb.append(ch);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}