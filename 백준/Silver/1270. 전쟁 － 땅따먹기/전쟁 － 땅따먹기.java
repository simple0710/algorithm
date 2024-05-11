import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String[] input = br.readLine().split(" ");
            int len = Integer.parseInt(input[0]);
            HashMap<Long, Integer> map = new HashMap<>();
            for (int i = 1; i <= len; i++) {
                long now = Long.parseLong(input[i]);
                map.put(now, map.getOrDefault(now, 0) + 1);
            }
            boolean flag = false;
            long res = 0;
            for (long key : map.keySet()) {
                if (map.get(key) > len / 2) {
                    flag = true;
                    res = key;
                    break;
                }
            }
            System.out.println(flag ? res : "SYJKGW");
        }
    }
}