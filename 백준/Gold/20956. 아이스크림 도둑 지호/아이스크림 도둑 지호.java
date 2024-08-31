import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        HashMap<Integer, ArrayDeque<Integer>> map = new HashMap<>();
        input = br.readLine().split(" ");
        Integer[] numArr = new Integer[N];
        for (int i = 0; i < N ; i++) {
            int now = Integer.parseInt(input[i]);
            if (map.get(now) == null) map.put(now, new ArrayDeque<>());
            map.get(now).add(i + 1);
            numArr[i] = now;
        }
        
        Arrays.sort(numArr, Collections.reverseOrder());
        
        boolean reverse = false;
        for (int i = 0; i < M; i++) {
            ArrayDeque<Integer> now = map.get(numArr[i]);
            sb.append(reverse ? now.pollLast() : now.poll()).append("\n");
            if (numArr[i] % 7 == 0) reverse = !reverse;
        }
        System.out.print(sb);
    }
}