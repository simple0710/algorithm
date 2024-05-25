import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	System.out.print(((N-1)/4%2==1?4-(N-1)%4:(N-1)%4)+1);
    }
}