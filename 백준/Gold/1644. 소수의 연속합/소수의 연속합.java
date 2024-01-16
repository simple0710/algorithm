import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static final int MAX = 4000000;
    static ArrayList<Integer> list = new ArrayList<>();
    public static void findPrime() {
        boolean[] primeNums = new boolean[MAX+1];
        for (int i = 2; i <= MAX; i++) {
            if (!primeNums[i]) {
                list.add(i);
                for (int j = i + i; j <= MAX; j+=i) {
                    primeNums[j] = true;
                }
            }
        }
    }

    public static int twoPointer(int N) {
        int s = 0, sum = 0;
        int res = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
            while (sum > N) {
                sum -= list.get(s);
                s++;
            }
            if (sum == N) res++;
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        findPrime();
        System.out.print(twoPointer(N));
    }
}