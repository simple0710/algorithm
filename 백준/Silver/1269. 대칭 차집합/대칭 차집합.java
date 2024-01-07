import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        HashSet<String> set1 = new HashSet<>(Arrays.asList(br.readLine().split(" ")));
        HashSet<String> set2 = new HashSet<>(Arrays.asList(br.readLine().split(" ")));
        HashSet<String> remove1 = new HashSet<>(set1);
        HashSet<String> remove2 = new HashSet<>(set2);
        remove1.removeAll(set2);
        remove2.removeAll(set1);
        remove1.addAll(remove2);
        System.out.print(remove1.size());
    }
}