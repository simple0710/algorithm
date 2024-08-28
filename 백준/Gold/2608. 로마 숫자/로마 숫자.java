import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<String, Integer> numMap;
    static Map<String, Integer> cntMap;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        initMaps();
        String num1 = br.readLine();
        String num2 = br.readLine();
        int sum = getNum(num1) + getNum(num2);
        System.out.println(sum);
        System.out.println(getWord(sum));
    }

    private static String getWord(int num) {
        StringBuilder sb = new StringBuilder();
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        for (int i = 0; i < symbols.length; i++) {
            while (num >= values[i]) {
                sb.append(symbols[i]);
                num -= values[i];
            }
        }
        return sb.toString();
    }

    private static void initMaps() {
        numMap = new HashMap<>();
        numMap.put("I", 1);
        numMap.put("V", 5);
        numMap.put("X", 10);
        numMap.put("L", 50);
        numMap.put("C", 100);
        numMap.put("D", 500);
        numMap.put("M", 1000);
        numMap.put("IV", 4);
        numMap.put("IX", 9);
        numMap.put("XL", 40);
        numMap.put("XC", 90);
        numMap.put("CD", 400);
        numMap.put("CM", 900);

        cntMap = new HashMap<>();
        cntMap.put("I", 3);
        cntMap.put("V", 1);
        cntMap.put("X", 3);
        cntMap.put("L", 1);
        cntMap.put("C", 3);
        cntMap.put("D", 1);
        cntMap.put("M", 3);
        cntMap.put("IV", 1);
        cntMap.put("IX", 1);
        cntMap.put("XL", 1);
        cntMap.put("XC", 1);
        cntMap.put("CD", 1);
        cntMap.put("CM", 1);
    }

    private static int getNum(String num) {
        int numValue = 0;
        Map<String, Integer> tempCntMap = new HashMap<>(cntMap);

        for (int i = 0; i < num.length(); i++) {
            String now = String.valueOf(num.charAt(i));
            String next = (i + 1 < num.length()) ? String.valueOf(num.charAt(i+1)) : "";

            String symbol = getSymbol(now, next);
            if (symbol.length() == 2) i++;

            tempCntMap.put(symbol, tempCntMap.get(symbol) - 1);
            numValue += numMap.get(symbol);
        }
        return numValue;
    }

    private static String getSymbol(String now, String next) {
        String combined = now + next;
        return numMap.containsKey(combined) ? combined : now;
    }
}