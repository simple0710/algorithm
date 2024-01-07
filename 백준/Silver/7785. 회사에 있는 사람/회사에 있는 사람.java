import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String enterFlag = st.nextToken();
            set.add(name);
            if (enterFlag.equals("leave")) set.remove(name);
        }
        List<String> list = new ArrayList<>(set);
        Collections.sort(list, Collections.reverseOrder());
        for (String name:list) System.out.println(name);
    }
}