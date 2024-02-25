import java.io.*;
import java.util.*;

public class Main {
	public static class Info {
		int v = 0;
		int boardCnt = 0;
		ArrayList<Integer> another = new ArrayList<>();
	}
	static int res;
	static int[][] parent;;
	static int[][] board;
	static String[][] resBoard = new String[][] {
		"..----..----..----..----..----..".split(""),
		"..    ..    ..    ..    ..    ..".split(""),
		"| \\                          / |".split(""),
		"|  \\                        /  |".split(""),
		"|   \\                      /   |".split(""),
		"|    ..                  ..    |".split(""),
		"..   ..                  ..   ..".split(""),
		"..     \\                /     ..".split(""),
		"|       \\              /       |".split(""),
		"|        \\            /        |".split(""),
		"|         ..        ..         |".split(""),
		"|         ..        ..         |".split(""),
		"..          \\      /          ..".split(""),
		"..           \\    /           ..".split(""),
		"|             \\  /             |".split(""),
		"|              ..              |".split(""),
		"|              ..              |".split(""),
		"|             /  \\             |".split(""),
		"..           /    \\           ..".split(""),
		"..          /      \\          ..".split(""),
		"|         ..        ..         |".split(""),
		"|         ..        ..         |".split(""),
		"|        /            \\        |".split(""),
		"|       /              \\       |".split(""),
		"..     /                \\     ..".split(""),
		"..   ..                  ..   ..".split(""),
		"|    ..                  ..    |".split(""),
		"|   /                      \\   |".split(""),
		"|  /                        \\  |".split(""),
		"| /                          \\ |".split(""),
		"..    ..    ..    ..    ..    ..".split(""),
		"..----..----..----..----..----..".split(""),
	};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[3][21]; // 현재 위치 포함 0이 시작
		parent = new int[2][4];
		for (int i = 0; i < 4; i++) {
			parent[0][i] = i;
			parent[1][i] = i;
		}
		Info[][] team = new Info[2][4];
		for (int i = 0; i < 4; i++) {
			team[0][i] = new Info();
			team[1][i] = new Info();
		}
		int N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char color = st.nextToken().charAt(0);
			int moveCnt = getMoveCnt(st.nextToken().toCharArray());
			int teamNo = color / 'a';
			int who = find(teamNo, color <= 'D' ? color % 'A' : color % 'a');
			Info now = team[teamNo][who];
			if (now.v == -1) now.another.clear();
			now.v += moveCnt; // 이동
			if (now.boardCnt == 0) {
				if (now.v % 5 == 0 && now.v <= 10) {
					now.boardCnt = now.v / 5;
					now.v = 0;
				}
			} else if (now.boardCnt == 1) {
				if (now.v == 3) now.boardCnt = 2;
				else if (now.v >= 6) {
					now.boardCnt = 0;
					now.v = 15 + now.v % 6;
				}
			} else if (now.boardCnt == 2) {
				if (now.v == 6) {
					now.boardCnt = 0;
					now.v = 20;
				}
			}
			
			if (now.v >= 21) {
				for (int i = 0; i < 4; i++) {
					if (find(teamNo, i) == who) now.v = 0;
				}
			}
			
			for (int i = 0; i < 4; i++) {
				if (i != who && team[teamNo][i].boardCnt == now.boardCnt && team[teamNo][i].v == now.v) {
					union(teamNo, i, who);
					if (find(teamNo, i) < who) {
						team[teamNo][i].another.addAll(now.another);
						now.v = 0;
						now.another.clear();
						team[teamNo][i].another.add(who);
					} else {
						now.another.addAll(team[teamNo][i].another);
						team[teamNo][i].v = 0;
						team[teamNo][i].another.clear();
						now.another.add(i);
					}
					break;
				}
			}
			
			for (int i = 0; i < 4; i++) {
				if (team[1-teamNo][i].boardCnt == now.boardCnt && team[1-teamNo][i].v == now.v) {
					team[1-teamNo][i].another.clear();
					team[1-teamNo][i].v = 0;
					for (int j = 0; j < 4; j++) {
						if (find(1-teamNo, j) == i) {
							parent[1-teamNo][j] = j;
							team[1-teamNo][i].another.clear();
						}
					}
				}
			}
		}
		int[][] moveArr1 = getMoveArr();
		int[][] moveArr2 = {{0, 30}, {5, 25}, {10, 20}, {15, 15}, {20, 10}, {25, 5}};
		int[][] moveArr3 = {{0, 0}, {5, 5}, {10, 10}, {15, 15}, {20, 20}, {25, 25}};
		int[][][] moveArr = new int[][][]{moveArr1, moveArr2, moveArr3};
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				if (team[i][j].boardCnt == 0 && team[i][j].v == 0) continue;
				int x = moveArr[team[i][j].boardCnt][team[i][j].v][0] + j / 2;
				int y = moveArr[team[i][j].boardCnt][team[i][j].v][1] + j % 2;
				for (int v : team[i][j].another) {
					int nx = moveArr[team[i][j].boardCnt][team[i][j].v][0] + v / 2;
					int ny = moveArr[team[i][j].boardCnt][team[i][j].v][1] + v % 2;
					resBoard[nx][ny] = String.valueOf((char) (v + (i == 0 ? 'A' : 'a')));
				}
				resBoard[x][y] = String.valueOf((char) (j + (i == 0 ? 'A' : 'a')));
			}
		}
		StringBuilder sb = new StringBuilder();
		for (String[] row : resBoard) {
			for (String v : row) sb.append(v);
			sb.append("\n");
		}
		System.out.print(sb);
	}
	public static int getMoveCnt(char[] str) {
		int cnt = 0;
		for (char v : str) {
			if (v == 'F') cnt++;
		}
		return cnt == 0 ? 5 : cnt;
	}
	
	public static int find(int no, int x) {
		if (x != parent[no][x]) parent[no][x] = find(no, parent[no][x]);
		return parent[no][x];
	}
	
	public static void union(int no, int a, int b) {
		a = find(no, a);
		b = find(no, b);
		parent[no][Math.max(a, b)] = Math.min(a, b);
	}
	
	public static int[][] getMoveArr() {
		int[] dx = {-6, 0, 6, 0}, dy = {0, -6, 0, 6};
		int[][] moveArr = new int[20][];
		int nx = 30, ny = 30;
		int d = 0;
		int cnt = 0;
		while (d < 4) {
			if (nx + dx[d] < 0 || 30 < nx + dx[d] || ny + dy[d] < 0 || 30 < ny + dy[d]) {
				d++;
				continue;
			}
			moveArr[cnt++] = new int[]{nx, ny};
			nx += dx[d];
			ny += dy[d];
		}
		return moveArr;
	}
}