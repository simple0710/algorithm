import java.io.*;
import java.util.*;

public class Main {
	static class Point {
		long x;
		long y;

		Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long x1 = Long.parseLong(st.nextToken());
		long y1 = Long.parseLong(st.nextToken());
		long x2 = Long.parseLong(st.nextToken());
		long y2 = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		long x3 = Long.parseLong(st.nextToken());
		long y3 = Long.parseLong(st.nextToken());
		long x4 = Long.parseLong(st.nextToken());
		long y4 = Long.parseLong(st.nextToken());
		Point a = new Point(x1, y1);
		Point b = new Point(x2, y2);
		Point c = new Point(x3, y3);
		Point d = new Point(x4, y4);
		int res1 = ccw(a, b, c) * ccw(a, b, d);
		int res2 = ccw(c, d, a) * ccw(c, d, b);
		if (res1 == 0 && res2 == 0) {
			if (Math.min(a.x, b.x) <= Math.max(c.x, d.x) && Math.min(c.x, d.x) <= Math.max(a.x, b.x) && 
					Math.min(a.y, b.y) <= Math.max(c.y, d.y) && Math.min(c.y, d.y) <= Math.max(a.y, b.y)) {
				System.out.print(1);
			} else System.out.print(0);
		} else if (res1 <= 0 && res2 <= 0) System.out.print(1);
		else System.out.print(0);
	}

	public static int ccw(Point a, Point b, Point c) {
		long res = (a.x * b.y + b.x * c.y + c.x * a.y) - (a.x * c.y + c.x * b.y + b.x * a.y);
		if (res == 0) return 0;
		else if (res > 0) return 1;
		else return -1;
	}
}