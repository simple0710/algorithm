import java.io.*;
import java.util.*;

public class Main {
	static int[] numsArr;
	static char[][] board;
	static boolean[] pick;
	static boolean flag;
	static ArrayList<int[]> placeArr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		numsArr = new int[12];
		board = new char[5][];
		pick = new boolean[12];
		placeArr = new ArrayList<>();
		int idx = 0;
		for (int i = 0; i < 5; i++) {
			board[i] = br.readLine().toCharArray();
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] != '.') {
					if (board[i][j] != 'x') {
						int now = board[i][j] - 'A';
						numsArr[idx] = now + 1; 
						pick[now] = true;
					}
					else placeArr.add(new int[] {idx, i, j});
					idx++;
				}
			}
		}
		
		flag = false;
		back(0);
		StringBuilder sb = new StringBuilder();
		for (int  i = 0; i < 5; i++) {
			for (int j = 0; j < 9; j++) sb.append(board[i][j]);
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	public static void back(int depth) {
		if (flag) return;
		if (depth == placeArr.size()) {
			if (check(1, 2, 3, 4) && check(7, 8, 9, 10) && check(0, 2, 5, 7) && check(4, 6, 9, 11) && check(1, 5, 8, 11) && check(0, 3, 6, 10)) {
				for (int[] v : placeArr) board[v[1]][v[2]] = (char) (numsArr[v[0]] + 'A' - 1);
				flag = true;
			}
			return;
		}
		
		for (int i = 0; i < 12; i++) {
			if (pick[i]) continue;
			pick[i] = true;
			numsArr[placeArr.get(depth)[0]] = i + 1;
			back(depth+1);
			pick[i] = false;
		}
	}
	
	public static boolean check(int... idxArr) {
		int check = 0;
		for (int v : idxArr) check += numsArr[v];
		return check == 26;
	}
}