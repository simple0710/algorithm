import java.io.*;
import java.util.*;

public class Main {
	static class Place {
		int x;
		int y;
		int d;
		boolean death = false;
		Place(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	static int res;
	static int[] dx ={-1, -1, 0, 1, 1, 1, 0, -1}, dy = {0, -1, -1, -1, 0, 1, 1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] board = new int[4][4];
		Place[] fish = new Place[17];
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int num = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				board[i][j] = num;
				fish[num] = new Place(i, j, d - 1);
			}
		}
		res = 0;
		int num = board[0][0];
		fish[num].death = true;
		board[0][0] = 0;
		back(num, board, fish, 0, 0, fish[num].d);
		System.out.print(res);
	}
	
	public static void back(int totalNum, int[][] board, Place[] fish,  int... shark) {
		res = Math.max(res, totalNum);
		Place[] newFish = getFishPlace(fish);
		int[][] newBoard = fishMove(board, newFish, shark);
		ArrayList<Place> canMoveList = sharkMove(newBoard, shark);
		if (!canMoveList.isEmpty()) {
			for (Place now : canMoveList) {
				int num = newBoard[now.x][now.y];
				newFish[num].death = true;
				newBoard[now.x][now.y] = 0; 
				back(totalNum + num, newBoard, newFish, now.x, now.y, newFish[num].d);
				newBoard[now.x][now.y] = num;
				newFish[num].death = false;
			}
		}
	}
	public static Place[] getFishPlace(Place[] fish) {
		Place[] newFish = new Place[17];
		for (int i = 1; i <= 16; i++) newFish[i] = fish[i];
		return newFish;
	}
	
	public static int[][] fishMove(int[][] board, Place[] fish, int... shark) {
		int sharkX = shark[0];
		int sharkY = shark[1];
		int[][] newBoard = new int[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				newBoard[i][j] = board[i][j];
			}
		}
		for (int i = 1; i <= 16; i++) {
			if (!fish[i].death) {
				int fishDirection = fish[i].d;
				while (true) {
					int nx = fish[i].x + dx[fishDirection];
					int ny = fish[i].y + dy[fishDirection];
					if (!isOut(nx, ny) & !(sharkX == nx && sharkY == ny)) {
						if (newBoard[nx][ny] != 0) {
							newBoard[fish[i].x][fish[i].y] = newBoard[nx][ny];
							fish[newBoard[nx][ny]] = new Place(fish[i].x, fish[i].y, fish[newBoard[nx][ny]].d); 
						} else newBoard[fish[i].x][fish[i].y] = 0; 
						newBoard[nx][ny] = i;
						fish[i] = new Place(nx, ny, fishDirection);
						break;
					}
					fishDirection = changeDirection(fishDirection);
				}
			}
		}
		return newBoard;
	}
	
	public static ArrayList<Place> sharkMove(int[][] board, int... shark) {
		int x = shark[0];
		int y = shark[1];
		int d = shark[2];
		ArrayList<Place> canMoveList = new ArrayList<>();
		while(!isOut(x, y)) {
			if (board[x][y] > 0) canMoveList.add(new Place(x, y, -1));
			x += dx[d];
			y += dy[d];
		}
		return canMoveList; 
	}
	
	public static int changeDirection(int d) {
		return (d + 1) % 8;
	}
	
	public static boolean isOut(int x, int y) {
		return x < 0 || x >= 4 || y < 0 || y >= 4;
	}
}