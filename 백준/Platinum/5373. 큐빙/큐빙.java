import java.io.*;
import java.util.*;

public class Main {
	static String[][][] cube = new String[6][3][3];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			cubeInit();
			br.readLine();
			String[] commands = br.readLine().split(" ");
			for (String c : commands) {
				spin(c.charAt(1), getSideNum(c.charAt(0)));
				if (c.charAt(1) == '+') plusCheck(c.charAt(0));
				else if (c.charAt(1) == '-') minusCheck(c.charAt(0));
			}
			for (int i = 0; i < 3; i++) {
				sb.append(String.join("", cube[0][i]));
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
	
	public static void cubeInit() {
		String[] shape = new String[] {"w", "y", "r", "o", "g", "b"};
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					cube[i][j][k] = shape[i];
				}
			}
		}
	}
	
	public static int getSideNum(char v) {
		char[] direction =  new char[] {'U', 'D', 'F', 'B', 'L', 'R'};
		for (int i = 0; i < 6; i++) {
			if (v == direction[i]) return i;
		}
		return 0;
	}

	public static void spin(char d, int now) {
		String[][] newCube = new String[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (d == '+') newCube[j][2-i] = cube[now][i][j];
				else newCube[i][j] = cube[now][j][2-i];
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cube[now][i][j] = newCube[i][j];
			}
		}
	}

	public static void plusCheck(char nowFace) {
		if(nowFace == 'U') UDSpin(0, 3, 5, 2, 4);
		else if(nowFace == 'D') UDSpin(2, 3, 4, 2, 5);
		
		else if(nowFace == 'F') FSpin(0, 1, 5, 0, 4);
		else if(nowFace == 'B') BSpin(0, 4, 0, 5, 1);
		
		else if (nowFace == 'L') LRSpin(0, 3, 0, 2, 1);
		else if(nowFace == 'R') LRSpin(2, 3, 1, 2, 0);
	}
	
	public static void minusCheck(char nowFace) {
		if(nowFace == 'U') UDSpin(0, 3, 4, 2, 5);
		else if(nowFace == 'D') UDSpin(2, 3, 5, 2, 4);
		
		else if(nowFace == 'F') BSpin(2, 4, 0, 5, 1);
		else if(nowFace == 'B') FSpin(2, 1, 5, 0, 4);
		
		else if (nowFace == 'L') LRSpin(0, 3, 1, 2, 0);
		else if(nowFace == 'R') LRSpin(2, 3, 0, 2, 1);
	}
	
	public static void UDSpin(int d, int... order) {
		String[] temp1 = getRow(d, order[0]);
		String[] temp2 = getRow(d, order[1]);
		String[] temp3 = getRow(d, order[2]);
		String[] temp4 = getRow(d, order[3]);
		for (int i = 0; i < 3; i++) {
			cube[order[0]][d][i] = temp4[i];
			cube[order[1]][d][i] = temp1[i];
			cube[order[2]][d][i] = temp2[i];
			cube[order[3]][d][i] = temp3[i];
		}
	}
	
	public static void FSpin(int d, int... order) {
		String[] temp1 = getRow(d, order[0]);
		String[] temp2 = getCol(d, order[1]);
		String[] temp3 = getRow(2-d, order[2]);
		String[] temp4 = getCol(2-d, order[3]);
		for (int i = 0; i < 3; i++) {
			cube[order[0]][d][i] = temp2[2-i];
			cube[order[1]][i][d] = temp3[i];
			cube[order[2]][2-d][i] = temp4[2-i];
			cube[order[3]][i][2-d] = temp1[i];
		}
	}

	public static void BSpin(int d, int... order) {
		String[] temp1 = getCol(d, order[0]);
		String[] temp2 = getRow(d, order[1]);
		String[] temp3 = getCol(2-d, order[2]);
		String[] temp4 = getRow(2-d, order[3]);
		for (int i = 0; i < 3; i++) {
			cube[order[0]][i][d] = temp2[2-i];
			cube[order[1]][d][i] = temp3[i];
			cube[order[2]][i][2-d] = temp4[2-i];
			cube[order[3]][2-d][i] = temp1[i];
		}
		
	}
	
	public static void LRSpin(int d, int... order) {
		String[] temp1 = getCol(2-d, order[0]); // 뒤
		String[] temp2 = getCol(d, order[1]);
		String[] temp3 = getCol(d, order[2]);
		String[] temp4 = getCol(d, order[3]);
		for (int i = 0; i < 3; i++) {
			cube[order[0]][i][2-d] = temp4[2-i];
			cube[order[1]][i][d] = temp1[2-i];
			cube[order[2]][i][d] = temp2[i];
			cube[order[3]][i][d] = temp3[i];
		}
	}
	
	public static String[] getRow(int d, int now) {
		String[] newTemp = new String[3];
		for (int i = 0; i < 3; i++) {
			newTemp[i] = cube[now][d][i];
		}
		return newTemp;
	}
	
	public static String[] getCol(int d, int now) {
		String[] newTemp = new String[3];
		for (int i = 0; i < 3; i++) {
			newTemp[i] = cube[now][i][d];
		}
		return newTemp;
	}
}