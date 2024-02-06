import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<>();
		
		int[] goodCnt = new int[101];
		int[] stn = new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			stn[i] = Integer.parseInt(st.nextToken());
			boolean flag = false;
			for (int j = 0; j < arr.size(); j++) {
				if (stn[arr.get(j)] == stn[i]) flag = true;
			}
			if (!flag) {
				if (arr.size() >= N) {
					Collections.sort(arr, new Comparator<Integer>() {
						@Override
						public int compare(Integer o1, Integer o2) {
							if (goodCnt[stn[o1]] == goodCnt[stn[o2]]) return o1 - o2; 
							return goodCnt[stn[o1]] - goodCnt[stn[o2]];
						}
					});
					goodCnt[stn[arr.get(0)]] = 0;
					arr.remove(0);
				}
				arr.add(i);
			}
			goodCnt[stn[i]]++;
		}
		boolean[] resArr = new boolean[101];
		for (int i = 0; i < arr.size(); i++) {
			resArr[stn[arr.get(i)]] = true;
		}
		for (int i = 0; i < 101; i++) {
			if (resArr[i]) System.out.print(i + " ");
		}
	}
}