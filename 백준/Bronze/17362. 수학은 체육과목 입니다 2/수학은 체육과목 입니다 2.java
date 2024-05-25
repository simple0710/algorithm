import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
        if ((N-1)/ 4 % 2 == 1) System.out.print(5-(N-1)%4);
        else System.out.println((N-1)%4+1);
    }
}