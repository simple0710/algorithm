import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('G', 1);
        map.put('C', 2);
        map.put('T', 3);
        String input = br.readLine();
        Character[][] board = new Character[][] {
                {'A', 'C', 'A', 'G'},
                {'C', 'G', 'T', 'A'},
                {'A', 'T', 'C', 'G'},
                {'G', 'A', 'G', 'T'}
        };
        Character now = input.charAt(N-1);
        for (int i = N-2; i >= 0; i--) now = board[map.get(input.charAt(i))][map.get(now)];
        System.out.print(now);
    }
}