import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[21];
        for (int i = 0; i < 21; i++) arr[i] = i;
        for (int i = 0; i < 10; i++) {
            String[] st = br.readLine().split(" ");
            int s = Integer.parseInt(st[0]);
            int e = Integer.parseInt(st[1]);
            for (int j = s; j <= (s + e) / 2; j++) {
                int tmp = arr[j];
                arr[j] = arr[e - (j - s)];
                arr[e - (j - s)] = tmp;
            }
        }
        for (int i = 1; i <= 20; i++) System.out.print(arr[i] + " ");
    }
}