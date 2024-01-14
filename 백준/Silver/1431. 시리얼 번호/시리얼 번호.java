import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) list.add(br.readLine());
        Collections.sort(list);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String a1, String a2) {
                if (a1.length() != a2.length()) return a1.length() - a2.length();
                else {
                    int sum1 = 0;
                    int sum2 = 0;
                    for (int i = 0; i < a1.length(); i++) {
                        if (Character.isDigit(a1.charAt(i))) {
                            sum1 += Integer.parseInt(String.valueOf(a1.charAt(i)));
                        }
                    }
                    for (int i = 0; i < a2.length(); i++) {
                        if (Character.isDigit(a2.charAt(i))) {
                            sum2 += Integer.parseInt(String.valueOf(a2.charAt(i)));
                        }
                    }
                    return sum1 - sum2;
                }
            };
        });
        StringBuilder sb = new StringBuilder();
        for (String now : list) {
            sb.append(now).append("\n");
        }
        System.out.print(sb);
    }
}