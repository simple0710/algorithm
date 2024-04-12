import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int res1 = 0;
        int res2 = 0;
        String[] str = br.readLine().split(" ");
        for (String time : str) {
            double now = Integer.parseInt(time);
            res1 += Math.ceil(now/30.0 + (now%30 == 0 ? 1 : 0)) * 10;
            res2 += Math.ceil(now/60.0 + (now%60 == 0 ? 1 : 0)) * 15;
        }
        if (res1 <= res2) System.out.print("Y ");
        if (res1 >= res2) System.out.print("M ");
        System.out.print(Math.min(res1, res2));
    }
}