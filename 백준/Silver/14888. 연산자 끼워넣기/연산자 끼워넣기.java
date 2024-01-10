import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] nums, operator;
    static int N;
    static long resMax, resMin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[N];
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        operator = new int[4];
        for (int i = 0; i < 4; i++) operator[i] = Integer.parseInt(st.nextToken());
        long MAX = 1000000001;
        resMax = -MAX;
        resMin = MAX;
        back(1, nums[0]);
        System.out.println(resMax);
        System.out.print(resMin);
    }

    public static void back(int depth, long sum) {
        if (depth == N) {
            resMax = Math.max(resMax, sum);
            resMin = Math.min(resMin, sum);
            return;
        }
        long value;
        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i] -= 1;
                if (i == 0) value = sum + nums[depth];
                else if (i == 1) value = sum - nums[depth];
                else if (i == 2) value = sum * nums[depth];
                else value = sum / nums[depth];
                back(depth+1,  value);
                operator[i] += 1;
            }
        }
    }
}