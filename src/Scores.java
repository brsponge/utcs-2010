import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Scores {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("scores.dat"));
		HashMap<Character, Integer> points = new HashMap<>();
		points.put('T', 6);
		points.put('K', 1);
		points.put('W', 2);
		points.put('B', 2);
		points.put('F', 3);
		points.put('S', 2);
		int N = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < N; i++) {
			String as = scanner.nextLine();
			String ap = scanner.nextLine();
			int a = 0;
			for (int j = 0; j < ap.length(); j++) {
				a += points.get(ap.charAt(j));
			}
			String bs = scanner.nextLine();
			String bp = scanner.nextLine();
			int b = 0;
			for (int j = 0; j < bp.length(); j++) {
				b += points.get(bp.charAt(j));
			}
			System.out.printf("%s %d %s %d %s Wins!\n", as, a, bs, b, a > b ? as : bs);
		}
	}
}
