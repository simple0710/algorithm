import java.io.*;
import java.util.*;

public class Main {
    static int Q, s, e;
    static ArrayList<Integer> numList, prefixList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Q = Integer.parseInt(br.readLine());
        numList = new ArrayList<>();
        prefixList = new ArrayList<>();
        numList.add(0);
        prefixList.add(0);
        s = 1;
        e = 1;
        while (Q-- > 0) {
            String[] input = br.readLine().split(" ");
            int command = Integer.parseInt(input[0]);
            if (command == 1) {
                int num = Integer.parseInt(input[1]);
                int listSize = prefixList.size();
                if (e < listSize) {
                    numList.set(e, num);
                    prefixList.set(e, prefixList.get(e - 1) + num);
                } else {
                    numList.add(num);
                    prefixList.add(prefixList.get(prefixList.size() - 1) + num);
                }
                e++;
            } else {
                int leftCheck = (int) Math.floor((double) (e - s) / 2);
                int rightCheck = (int) Math.ceil((double) (e - s) / 2);
                int leftSum = prefixList.get(s + leftCheck - 1) - prefixList.get(s - 1);
                int rightSum = prefixList.get(e-1) - prefixList.get(e - rightCheck - 1);
                if (leftSum <= rightSum) {
                    // 왼쪽 배열 삭제
                    sb.append(leftSum).append("\n");
                    s += leftCheck;
                } else {
                    // 오른쪽 배열 삭제
                    sb.append(rightSum).append("\n");
                    e -= rightCheck;
                }
            }
        }
        for (int i = s; i < e; i++) sb.append(numList.get(i)).append(" ");
        System.out.print(sb);
    }
}