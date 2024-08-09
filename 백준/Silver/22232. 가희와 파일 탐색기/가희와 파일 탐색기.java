import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        String[][] fileNameArr = new String[N][2];
        for (int i = 0; i < N; i++) {
            String file = br.readLine();
            String[] fileSplit = file.split("\\.");
            fileNameArr[i][0] = fileSplit[0];
            if (fileSplit.length > 1) fileNameArr[i][1] = fileSplit[1];
        }
        HashSet<String> set = new HashSet<>();
        while (M-- > 0) set.add(br.readLine());

        Arrays.sort(fileNameArr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                int nameCompare = o1[0].compareTo(o2[0]);
                if (nameCompare != 0) return nameCompare;

                boolean o1InSet = set.contains(o1[1]);
                boolean o2InSet = set.contains(o2[1]);
                if (o1InSet && !o2InSet) return -1;
                if (!o1InSet && o2InSet) return 1;
                return o1[1].compareTo(o2[1]);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(fileNameArr[i][0]);
            if (fileNameArr[i][1] != null) {
                sb.append(".").append(fileNameArr[i][1]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}