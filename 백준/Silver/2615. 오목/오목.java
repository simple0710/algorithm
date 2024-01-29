import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] board = new int[19][19];
		for (int i = 0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int flag = 0;
		int p1 = 0;
		int p2 = 0;
		for (int i = 0; i < 19; i++) {
			int row = 0;
			int col = 0;
			for (int j = 1; j < 19; j++) {
				if (board[i][j] == 0 || board[i][j] != board[i][j - 1]) {
					if (row == 4) {
						flag = board[i][j - 1];
						p1 = i;
						p2 = j - 5;
					}
					row = 0;
				} else row++;
				if (board[j][i] == 0 || board[j][i] != board[j - 1][i]) {
					if (col == 4) {
						flag = board[j - 1][i];
						p1 = j - 5;
						p2 = i;
					}
					col = 0;
				} else col++;
			}
			if (row == 4) {
				flag = board[i][18];
				p1 = i;
				p2 = 14;
			}
			if (col == 4) {
				flag = board[18][i];
				p1 = 14;
				p2 = i;
			}
			int diaLToRD = 0;
			int ni = i+1;
			int nj = 1;
			while (ni < 19 && nj < 19) {
				if (board[ni][nj] == 0 || board[ni][nj] != board[ni-1][nj-1]) {
					if (diaLToRD == 4) {
						flag = board[ni-1][nj-1];
						p1 = ni - 5;
						p2 = nj - 5;
					}
					diaLToRD = 0;
				} else
					diaLToRD++;
				ni++;
				nj++;
			}
			if (diaLToRD == 4) {
				flag = board[ni-5][nj-5];
				p1 = ni-5;
				p2 = nj-5;
			}
			int diaUToRD = 0;
			ni = 1;
			nj = i+1;
			while (ni < 19 && nj < 19) {
				if (board[ni][nj] == 0 || board[ni][nj] != board[ni-1][nj-1]) {
					if (diaUToRD == 4) {
						flag = board[ni-1][nj-1];
						p1 = ni - 5;
						p2 = nj - 5;
					}
					diaUToRD = 0;
				} else
					diaUToRD++;
				ni++;
				nj++;
			}
			if (diaUToRD == 4) {
				flag = board[ni-5][nj-5];
				p1 = ni-5;
				p2 = nj-5;
			}
			
			int diaLToUR = 0;
			ni = i-1;
			nj = 1;
			while (ni >= 0 && nj < 19) {
				if (board[ni][nj] == 0 || board[ni][nj] != board[ni+1][nj-1]) {
					if (diaLToUR == 4) {
						flag = board[ni+1][nj-1];
						p1 = ni + 5;
						p2 = nj - 5;
					}
					diaLToUR = 0;
				} else
					diaLToUR++;
				ni--;
				nj++;
			}
			if (diaLToUR == 4) {
				flag = board[ni+5][nj-5];
				p1 = ni+5;
				p2 = nj-5;
			}
			int diaDToR = 0;
			ni = 17;
			nj = i+1;
			while (ni >= 0 && nj < 19) {
				if (board[ni][nj] == 0 || board[ni][nj] != board[ni+1][nj-1]) {
					if (diaDToR == 4) {
						flag = board[ni+1][nj-1];
						p1 = ni + 5;
						p2 = nj - 5;
					}
					diaDToR = 0;
				} else
					diaDToR++;
				ni--;
				nj++;

			}
			if (diaDToR == 4) {
				flag = board[ni+5][nj-5];
				p1 = ni+5;
				p2 = nj-5;
			}
		}
		p1++;
		p2++;
		System.out.println(flag);
		if (flag != 0) System.out.println(p1 + " " + p2);
	}
}