import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) list.add(Integer.parseInt(br.readLine()));
        Collections.sort(list, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (int value : list) sb.append(value).append("\n");
        System.out.print(sb);
    }
}