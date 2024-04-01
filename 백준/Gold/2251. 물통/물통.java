import java.io.*;
import java.util.*;

public class Main {
	static int A, B, C;
	static boolean[][] visited;
	static ArrayList<Integer> res;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	A = Integer.parseInt(st.nextToken());
    	B = Integer.parseInt(st.nextToken());
    	C = Integer.parseInt(st.nextToken());
    	visited = new boolean[A+1][B+1];
    	res = new ArrayList<>();
    	dfs(0, 0);
    	Collections.sort(res);
    	StringBuilder sb = new StringBuilder();
    	for (int now : res) sb.append(now).append(" ");
    	System.out.print(sb);
	}

	private static void dfs(int a, int b) {
		if (visited[a][b]) return;
		visited[a][b] = true;
		int c = C - a - b;
		if (a == 0) res.add(c);
		// x to c
		dfs(0, b);
		dfs(a, 0);
		
		// a to b, b to a
		dfs(Math.max(a+b-B, 0), Math.min(B, a+b));
		dfs(Math.min(A, a+b), Math.max(a+b-A, 0));
		
		// c to x
		dfs(Math.min(a+c, A), b);
		dfs(a, Math.min(b+c, B));
	}
}