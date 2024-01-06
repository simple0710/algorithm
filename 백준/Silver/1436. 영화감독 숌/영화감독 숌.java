import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = 666;
        while (N > 0) {
            String nowNumber = String.valueOf(cnt);
            if (nowNumber.contains("666")) N--;
            cnt++;
        }
        System.out.println(cnt-1);
    }
}