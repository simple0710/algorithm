import java.io.*;
import java.util.*;

public class Main {
    static int R, C, paperCnt;
    static ArrayList<int[]> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        paperCnt = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        int missPaper = Integer.parseInt(br.readLine());
        for (int i = 0; i < missPaper; i++) {
            input = br.readLine().split(" ");
            int r = Integer.parseInt(input[0]);
            int c = Integer.parseInt(input[1]);
            list.add(new int[] {r, c});
        }
        Collections.sort(list, (o1, o2) -> o1[1] - o2[1]);

        System.out.print(binarySearch());
    }

    public static int binarySearch() {
        int s = 1;
        int e = Math.min(R, C);
        while (s <= e) {
            int mid = (s + e) / 2;
            if (canBlind(mid)) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return s;
    }

    public static boolean canBlind(int mid) {
        int cnt = 0;
        int pre = 0;
        for (int[] now : list) {
            if (now[0] > mid) return false;
            if (pre == 0 || pre + mid <= now[1]) {
                pre = now[1];
                cnt++;
                if (cnt > paperCnt) return false;
            }
        }
        return true;
    }
}