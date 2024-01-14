import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static class Data {
        int x;
        int y;
        public Data(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Data> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Data(x, y));
        }
        Collections.sort(list, new Comparator<Data>() {
           @Override
           public int compare(Data d1, Data d2) {
               if (d1.y==d2.y) return d1.x-d2.x;
               return d1.y-d2.y;
           }
        });
        StringBuilder sb = new StringBuilder();
        for (Data value : list) {
            sb.append(value.x).append(" ").append(value.y).append("\n");
        }
        System.out.print(sb);
    }
}