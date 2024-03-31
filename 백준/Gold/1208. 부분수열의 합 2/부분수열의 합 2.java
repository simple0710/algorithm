import java.io.*;
import java.util.*;

public class Main {
	static int N, S;
	static long[] arr;
	static List<Long> left = new ArrayList<>();
	static List<Long> right = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        
        arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Long.parseLong(st.nextToken());
        
        getSub(0, N/2, 0, left);
        getSub(N/2, N, 0, right);
        
        Collections.sort(left);
        Collections.sort(right);
        
        long cnt = getCnt();
        
        if (S == 0) cnt--;
        
        bw.write(cnt + "\n");
        bw.flush();
    }
    
	private static void getSub(int start, int end, long sum, List<Long> list) {
		if (start == end) {
			list.add(sum);
			return;
		}
		
		getSub(start + 1, end, sum + arr[start], list);
		getSub(start + 1, end, sum, list);
		
	}
	
	private static long getCnt() {
		int pl = 0;
		int pr = right.size() - 1;
		long cnt = 0;
		while (pl < left.size() && pr >= 0) {
			long sum = left.get(pl) + right.get(pr);
			
			if (sum == S) {
				long a = left.get(pl);
				long cnt1 = 0;
				while (pl < left.size() && left.get(pl) == a) {
					pl++;
					cnt1++;
				}
				
				long b = right.get(pr);
				long cnt2 = 0;
				while (pr >= 0 && right.get(pr) == b) {
					pr--;
					cnt2++;
				}
				cnt += cnt1 * cnt2;
			} else if (sum < S) pl++;
			else pr--;
		}
		return cnt;
	}
}