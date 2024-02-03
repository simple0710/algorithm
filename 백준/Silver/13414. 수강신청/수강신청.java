import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		HashMap<String, Integer> map = new HashMap<>();
		int K = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		for (int i = 0; i < L; i++) map.put(br.readLine(), i);
		List<Entry<String, Integer>> resArr = new ArrayList<>(map.entrySet());
		Collections.sort(resArr, new Comparator<Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		for (int i = 0; i < Math.min(K, resArr.size()); i++) {
			sb.append(resArr.get(i).getKey()).append("\n");
		}
		System.out.print(sb);
	}
}