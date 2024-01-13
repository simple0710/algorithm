import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[2000001];
        for (int i = 0; i < N; i++) arr[Integer.parseInt(br.readLine()) + 1000000]++;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2000001; i++) {
            for (int j = 0; j < arr[i]; j++) {
                sb.append(i-1000000).append("\n");
            }
        }
        System.out.print(sb);
    }
}