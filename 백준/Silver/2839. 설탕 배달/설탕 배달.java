import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int res = N;
        for (int i = 0; i <= (int) N / 3 ; i++) {
            if ((N - 3 * i) % 5 == 0) res = Math.min(res, i + (N - 3 * i) / 5);
        }
        System.out.println(res != N ? res : -1);
    }
}