import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextInt();
        long res = recursion(N);
        System.out.println(res);
    }

    public static long recursion(long N) {
        if (N <= 1) return 1;
        return N * recursion(N-1);
    }
}