import java.io.*;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int num = N;
        while (num >= 0) System.out.println(getText(num--) + "\n");
    }

    public static String getText(int num) {
        return getFirstLine(num) + "\n" + getSecondLine(num-1);
    }

    private static String getFirstLine(int num) {
        return num > 0 ?
            String.format("%s %s of beer on the wall, %s %s of beer.", num, num > 1 ? "bottles" : "bottle", num, num == 1 ? "bottle" : "bottles")
            : "No more bottles of beer on the wall, no more bottles of beer.";
    }

    private static String getSecondLine(int num) {
        if (num >= 0) return String.format("Take one down and pass it around, %s %s of beer on the wall.", num > 0 ? num : "no more", num == 1 ? "bottle" : "bottles");
        return String.format("Go to the store and buy some more, %d %s of beer on the wall.", N, N == 1 ? "bottle" : "bottles");
    }
}