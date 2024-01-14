import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) list.add(str.substring(i, str.length()));
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (String s : list) sb.append(s).append("\n");
        System.out.print(sb);
    }
}