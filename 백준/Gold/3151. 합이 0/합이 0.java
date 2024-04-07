import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        long res = 0;
        for (int i = 0; i < N-2; i++) res += twoPointer(i);
        System.out.print(res);
    }

    private static int twoPointer(int now) {
        int s = now + 1;
        int e = N - 1;
        int cnt = 0;
        while (s < e) {
            int sum = arr[now] + arr[s] + arr[e];
            if (sum <= 0) {
                if (sum == 0) {
                    if (arr[s] == arr[e]) cnt += e - s;
                    else cnt += e - binarySearch(e) + 1;
                }
                s++;
            } else e--;
        }
        return cnt;
    }

    private static int binarySearch(int v) {
        int now = arr[v];
        int s = 0;
        int e = N-1;
        while (s < e) {
            int mid = (s + e) / 2;
            if (arr[mid] < now) s = mid + 1;
            else e = mid;
        }
        return e;
    }
}