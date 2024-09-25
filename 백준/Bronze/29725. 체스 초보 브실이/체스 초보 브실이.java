import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Character, Integer> scoreDic = new HashMap<>();
        scoreDic.put('K', 0);
        scoreDic.put('P', 1);
        scoreDic.put('N', 3);
        scoreDic.put('B', 3);
        scoreDic.put('R', 5);
        scoreDic.put('Q', 9);

        int bSum = 0;
        int wSum = 0;

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 8; i++) {
            String[] board = scanner.nextLine().split("");
            for (String piece : board) {
                if (piece.equals(".")) {
                    continue;
                }

                char name = piece.charAt(0);
                if (Character.isUpperCase(name)) {
                    wSum += scoreDic.get(name);
                } else {
                    bSum += scoreDic.get(Character.toUpperCase(name));
                }
            }
        }

        System.out.print(wSum - bSum);
    }
}