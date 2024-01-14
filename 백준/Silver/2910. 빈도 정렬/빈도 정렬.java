import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Data {
        int cnt;
        int idx;
        public Data(int cnt, int idx) {
            this.cnt = cnt;
            this.idx = idx;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Long, Data> numCntMap = new HashMap<>();
        HashSet<Long> numSet = new HashSet<>();
        int N = Integer.parseInt(st.nextToken());
        long C = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            long c = Long.parseLong(st.nextToken());
            if (!numCntMap.containsKey(c)) numCntMap.put(c, new Data(1, i));
            else numCntMap.get(c).cnt++;
            numSet.add(c);
        }
        ArrayList<Long> numList = new ArrayList<>(numSet);
        Collections.sort(numList, new Comparator<Long>() {
           @Override
           public int compare(Long n1, Long n2) {
               if (numCntMap.get(n2).cnt == numCntMap.get(n1).cnt) return numCntMap.get(n1).idx - numCntMap.get(n2).idx;
               return numCntMap.get(n2).cnt - numCntMap.get(n1).cnt;
           }
        });
        StringBuilder sb = new StringBuilder();
        for (long num : numList) {
            int numLength = numCntMap.get(num).cnt;
            for (int j = 0; j < numLength; j++) sb.append(num).append(" ");
        }
        System.out.print(sb);
    }
}