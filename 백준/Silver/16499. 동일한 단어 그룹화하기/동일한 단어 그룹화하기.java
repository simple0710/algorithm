import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split("");
            Arrays.sort(arr);
            StringBuilder word = new StringBuilder();
            for (String c : arr) word.append(c);
            set.add(word.toString());
        }
        System.out.print(set.size());
    }
}