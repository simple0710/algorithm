import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<String, String[]> teamMap = new HashMap<>();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		while (N-- > 0) {
			String teamName = br.readLine();
			int memberCnt = Integer.parseInt(br.readLine());
			String[] members = new String[memberCnt];
			for (int i = 0; i < memberCnt; i++) {
				members[i] = br.readLine();
			}
			Arrays.sort(members);
			teamMap.put(teamName, members);
		}
		while (M-- > 0) {
			String teamOrName = br.readLine();
			int questionType = Integer.parseInt(br.readLine());
			if (questionType == 0) {
				for (String name : teamMap.get(teamOrName)) {
					System.out.println(name);
				}
			} else {
				for (String teamName : teamMap.keySet()) {
					for (String name : teamMap.get(teamName)) {
						if (teamOrName.equals(name)) {
							System.out.println(teamName);
						}
					}
				}
			}
		}
	}
}