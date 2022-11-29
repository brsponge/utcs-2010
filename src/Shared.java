import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Shared {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("shared.dat"));
		int N = scanner.nextInt();
		for (int i = 0; i < N; i++) {
			Rect a = new Rect();
			a.x1 = scanner.nextInt();
			a.y1 = scanner.nextInt();
			a.x2 = scanner.nextInt();
			a.y2 = scanner.nextInt();
			Rect b = new Rect();
			b.x1 = scanner.nextInt();
			b.y1 = scanner.nextInt();
			b.x2 = scanner.nextInt();
			b.y2 = scanner.nextInt();
			Rect c = intersection(a, b);
			int area = area(c);
			if (area < 0)
				System.out.println(0);
			else
				System.out.println(area);
		}
	}

	private static Rect intersection(Rect a, Rect b) {
		Rect c = new Rect();
		c.x1 = Math.max(Math.min(a.x1, a.x2), Math.min(b.x1, b.x2));
		c.y1 = Math.max(Math.min(a.y1, a.y2), Math.min(b.y1, b.y2));
		c.x2 = Math.min(Math.max(a.x1, a.x2), Math.max(b.x1, b.x2));
		c.y2 = Math.min(Math.max(a.y1, a.y2), Math.max(b.y1, b.y2));
		return c;
	}

	private static int area(Rect r) {
		return (r.x2 - r.x1) * (r.y2 - r.y1);
	}

	private static class Rect {
		int x1;
		int y1;
		int x2;
		int y2;
	}
}
