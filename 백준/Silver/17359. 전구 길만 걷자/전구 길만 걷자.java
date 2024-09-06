import java.io.*;

class Main {
    static int N, res;
    static int[] changeCntArr;
    static String[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        res = Integer.MAX_VALUE;
        N = Integer.parseInt(br.readLine());
        arr = new String[N];
        changeCntArr = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            String now = br.readLine();
            int cnt = 0;
            for (int j = 1; j < now.length(); j++) {
                if (now.charAt(j-1) != now.charAt(j)) cnt++;
            }
            arr[i] = now;
            changeCntArr[i] = cnt;
        }
        back(0, "", 0);
        System.out.print(res);
    }

    private static void back(int depth, String now, int cnt) {
        if (depth == N) {
            res = Math.min(res, cnt);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int changeCnt = cnt + changeCntArr[i];
                if (!now.isEmpty() && now.charAt(now.length()-1) != arr[i].charAt(0)) changeCnt++;
                back(depth + 1, arr[i], changeCnt);
                visited[i] = false;
            }
        }
    }
}