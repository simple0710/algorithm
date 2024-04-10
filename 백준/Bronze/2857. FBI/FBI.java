import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            if (br.readLine().contains("FBI")) sb.append(i).append(" ");
        }
        System.out.print(sb.isEmpty() ? "HE GOT AWAY!" : sb);
    }
}