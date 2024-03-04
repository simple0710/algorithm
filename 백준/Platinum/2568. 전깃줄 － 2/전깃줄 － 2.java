import java.io.*;
import java.util.*;

public class Main {
	static int[] idxArr;
	static ArrayList<Integer> sortList;
	static ArrayList<int[]> lineList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		lineList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			lineList.add(new int[] {x, y});
		}
		Collections.sort(lineList, (o1, o2) -> Integer.compare(o1[0], o2[0]));
		
		sortList = new ArrayList<>();
		sortList.add(-1);
		idxArr = new int[N];
		for (int i = 0; i < N; i++) binarySearch(lineList.get(i)[1], i);
		
		int idx = sortList.size() - 1;
		StringBuilder sb = new StringBuilder();
		sb.append(N - (sortList.size() - 1)).append("\n");
		for (int i = N - 1; i >= 0; i--) {
			if (idx == idxArr[i]) {
				idx--;
				idxArr[i] = -1;
			}
		}
		
		for (int i = 0; i < N; i++) {
			if (idxArr[i] != -1) {
				sb.append(lineList.get(i)[0]).append("\n");
			}
		}
		System.out.print(sb);
	}
	
	public static void binarySearch(int num, int idx) {
		if (sortList.get(sortList.size() - 1) < num) {
			sortList.add(num);
			idxArr[idx] = sortList.size() - 1;
		} else {
			int s = 0, e = sortList.size() - 1;
			while (s < e) {
				int mid = (s + e) / 2;
				if (sortList.get(mid) > num) e = mid;
				else s = mid + 1;
			}
			sortList.set(e, num);
			idxArr[idx] = e;
		}
	}
}