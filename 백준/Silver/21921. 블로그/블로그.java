import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N, X, res, cnt, visitor;
        int[] arr;
        N = Integer.parseInt(input[0]);
        X = Integer.parseInt(input[1]);
        res = 0;
        cnt = 0;
        arr = new int[N+X+1];
        input = br.readLine().split(" ");
        for (int i = X; i < N+X; i++) {
            arr[i] = Integer.parseInt(input[i-X]) + arr[i-1];
            visitor = arr[i] - arr[i-X];
            if (res < visitor) {
                res = visitor;
                cnt = 0;
            }
            if (res == visitor) cnt++;
        }
        System.out.print(res == 0 ? "SAD" : String.format("%d\n%d", res, cnt));
    }
}