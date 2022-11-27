import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Boxes {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("boxes.dat"));
		int N = scanner.nextInt();
		for (int i = 0; i < N; i++) {
			int M = scanner.nextInt();
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			int total = 0;
			for (int j = 0; j < M; j++) {
				int v = scanner.nextInt() * scanner.nextInt() * scanner.nextInt();
				total += v;
				min = Math.min(v, min);
				max = Math.max(v, max);
			}
			System.out.printf("""
					Box Set %d
					%d
					%d, %d
					""", i + 1, total, max, min);
		}
	}
}
