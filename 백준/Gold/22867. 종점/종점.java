import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<int[]> busList = new ArrayList<>();
        PriorityQueue<Integer> outPq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int[] S = Arrays.stream(input[0].split("[:.]"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] E = Arrays.stream(input[1].split("[:.]"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int s = getTime(S);
            int e = getTime(E);
            busList.add(new int[]{s, e});
        }

        Collections.sort(busList, (o1, o2) -> o1[0] - o2[0]);
        
        int res = 0;
        for (int[] bus : busList) {
            while (!outPq.isEmpty() && outPq.peek() <= bus[0]) outPq.poll();
            outPq.add(bus[1]);
            res = Math.max(res, outPq.size());
        }
        System.out.print(res);
    }

    private static int getTime(int[] s) {
        return s[0] * 3_600_000 + s[1] * 60_000 + s[2] * 1_000 + s[3];
    }
}