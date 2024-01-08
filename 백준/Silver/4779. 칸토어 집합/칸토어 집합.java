import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static String[] string;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String check;
        while ((check = br.readLine()) != null) {
            int N = Integer.parseInt(check);
            int StringSize = (int) Math.pow(3, N);
            string = new String[StringSize];
            Arrays.fill(string, "-");
            recursion(0, StringSize);
            System.out.println(String.join("", string));
        }
    }
    public static void recursion(int start, int size) {
        if (size == 1) return;
        int newSize = size/3;
        for (int i = start+newSize; i < start + 2 * newSize; i++) {
            string[i] = " ";
        }
        recursion(start, newSize);
        recursion(start+2*newSize, newSize);
    }
}