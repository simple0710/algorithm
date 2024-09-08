import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        char[] line = br.readLine().toCharArray();
        int gap = 0;
        int i = 0;
        for (; i < line.length; i++) {
            int plus = line[i] == 'M' ? 1 : -1;
            if (Math.abs(gap + plus) > X) {
                if (i == line.length - 1 || line[i] == line[i+1]) break;
                char temp = line[i+1];
                line[i+1] = line[i];
                line[i] = temp;
                plus *= -1;
            }
            gap += plus;
        }
        System.out.print(i);
    }
}