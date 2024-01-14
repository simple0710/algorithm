import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> hash = new HashMap<>();
        long res = 0;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            long v = Long.parseLong(br.readLine());
            hash.put(v, hash.getOrDefault(v, 0) + 1);
            if (cnt < hash.get(v)) {
                res = v;
                cnt = hash.get(v);
            } else if (cnt == hash.get(v)) res = Math.min(res, v);
        }
        System.out.print(res);
    }
}