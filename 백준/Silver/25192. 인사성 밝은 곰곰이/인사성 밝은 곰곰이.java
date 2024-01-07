import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        int res = 0;
        for (int i = 0; i < N; i++) {
            String log = br.readLine();
            if (log.equals("ENTER")) {
                res += set.size();
                set = new HashSet<>();
            } else set.add(log);
        }
        res += set.size();
        System.out.println(res);
    }
}