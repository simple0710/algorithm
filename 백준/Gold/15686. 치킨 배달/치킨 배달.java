import java.io.*;
import java.util.*;

public class Main {
	public static class Place {
		int x;
		int y;
		Place(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int N, M, res;
	static Place[] pick;
	static ArrayList<Place> human, chicken;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] board = new int[N][N];
		human = new ArrayList<>();
		chicken = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1) human.add(new Place(i, j));
				else if (board[i][j] == 2) chicken.add(new Place(i, j));
			}
		}
		res = Integer.MAX_VALUE;
		pick = new Place[M];
		back(0, 0);
		System.out.print(res);
	}

	public static void back(int depth, int start) {
		if (depth == M) {
			int check = 0;
			for (Place now : human) {
				int minDistance = Integer.MAX_VALUE;
				for (Place v : pick) {
					minDistance = Math.min(minDistance, Math.abs(now.x - v.x) + Math.abs(now.y - v.y));
				}
				check += minDistance;
			}
			res = Math.min(res, check);
			return;
		}
		for (int i = start; i < chicken.size(); i++) {
			pick[depth] = chicken.get(i);
			back(depth + 1, i + 1);
		}
	}
}