import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            int totalCnt = 0;
            int R = 0;
            while (!"".equals(input = br.readLine())) {
                for (char c : input.toCharArray()) {
                    if (c != '#') R++;
                    totalCnt++;
                }
            }
            int a = (int) Math.round(R * 1000.0 / totalCnt);
            sb.append("Efficiency ratio is ");
            if (a % 10 > 0) sb.append(a / 10.0);
            else sb.append(a / 10);
            sb.append("%.").append("\n");
        }
        System.out.print(sb);
    }
}