import java.io.*;
import java.util.*;

public class Main {
	static class Place {
		int x;
		int y;
		Place(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class Command {
		int time;
		char command;
		Command (int time, char command) {
			this.time = time;
			this.command = command;
		}
	}
	
	static int N;
	
	static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
	static boolean[][] snakeBoard;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		boolean[][] board = new boolean[N+1][N+1];
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while (K-- > 0) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			board[row][col] = true;
		}
		int L = Integer.parseInt(br.readLine());
		Deque<Place> snake = new LinkedList<>();
		ArrayList<Command> commandList = new ArrayList<>();
		snake.add(new Place(1, 1));
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			char command = st.nextToken().charAt(0);
			commandList.add(new Command(time, command));
		}
		
		int nowCommand = 0;
		int nowD = 0;
		int t = 1;
		snakeBoard = new boolean[N+1][N+1];
		snakeBoard[1][1] = true;
		while (true) {
			Place head = snake.getFirst();
			int nx = head.x + dx[nowD];
			int ny = head.y + dy[nowD];
			if (isTouchWallOrBody(nx, ny)) break;
			
			if (snakeBoard[nx][ny]) break;

			if (!board[nx][ny]) {
				Place tail = snake.pollLast();
				snakeBoard[tail.x][tail.y] = false;
			} else board[nx][ny] = false;
			
			snake.addFirst(new Place(nx, ny));
			snakeBoard[nx][ny] = true;

			if (nowCommand < L && t == commandList.get(nowCommand).time) {
				nowD = (nowD + (commandList.get(nowCommand).command == 'L' ? 3 : 1)) % 4;
				nowCommand++;
			}
			t++;
		}
		System.out.print(t);
	}
	
	public static boolean isTouchWallOrBody(int x, int y) {
		return x <= 0 || x > N || y <= 0 || y > N;
	}
}