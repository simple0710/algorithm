import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        String res;
        if (M <= 2) res = "NEWBIE!";
        else if (M <= N) res = "OLDBIE!";
        else res = "TLE!";
        System.out.print(res);
    }
}