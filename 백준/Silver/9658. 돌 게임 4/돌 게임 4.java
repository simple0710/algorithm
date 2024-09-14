import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.print((N % 7 == 1 || N % 7 == 3) ? "CY" : "SK");
    }
}