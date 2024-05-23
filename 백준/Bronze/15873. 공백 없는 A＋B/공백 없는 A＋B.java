import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                String str = sc.nextLine();
                if (str.charAt(1) == '0') {
                        System.out.println(10 + Integer.parseInt(str.substring(2)));
                } else { 
                        System.out.println(Character.getNumericValue(str.charAt(0)) + Integer.parseInt(str.substring(1)));
                }
                sc.close();
        }
}