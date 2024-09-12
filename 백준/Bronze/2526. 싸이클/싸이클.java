import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        
        Map<Integer, Integer> seen = new HashMap<>();
        int current = N;
        int index = 0;
        
        while (!seen.containsKey(current)) {
            seen.put(current, index);
            current = (current * N) % P;
            index++;
        }
        
        int cycleStart = seen.get(current);
        int cycleLength = index - cycleStart;
        
        System.out.print(cycleLength);
    }
}