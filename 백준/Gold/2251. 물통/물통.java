import java.io.*;
import java.util.*;

public class Main {
	static int A, B, C;
	static boolean[][] visited;
	static HashSet<Integer> set;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	A = Integer.parseInt(st.nextToken());
    	B = Integer.parseInt(st.nextToken());
    	C = Integer.parseInt(st.nextToken());
    	visited = new boolean[A+1][B+1];
    	set = new HashSet<>();
    	dfs(0, 0);
    	ArrayList<Integer> res = new ArrayList<>(set);
    	Collections.sort(res);
    	StringBuilder sb = new StringBuilder();
    	for (int now : res) sb.append(now).append(" ");
    	System.out.print(sb);
	}

	private static void dfs(int a, int b) {
		if (visited[a][b]) return;
		visited[a][b] = true;
		int c = C - a - b;
		if (a == 0) set.add(c);
		dfs(0, b);
		dfs(a, 0);

        dfs(Math.max(a + b - B, 0), Math.min(B, a + b));
		dfs(Math.min(A, a+b), Math.max(a + b - A, 0));
		
		dfs(Math.min(a + c, A), b);
		dfs(a, Math.min(b + c, B));
	}
}