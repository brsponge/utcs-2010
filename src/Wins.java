import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Wins {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("wins.dat"));
		int N = scanner.nextInt();
		for (int i = 0; i < N; i++) {
			int T = scanner.nextInt();
			int G = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Data Set " + (i + 1));
			for (int j = 0; j < T; j++) {
				String name = scanner.nextLine();
				String scores = scanner.nextLine();
				int wins = 0;
				int losses = 0;
				System.out.println(name);
				for (int k = 0; k < G; k++) {
					wins += scores.charAt(k) == 'W' ? 1 : 0;
					losses += scores.charAt(k) == 'L' ? 1 : 0;
				}
				if (wins < G / 2.0) {
					System.out.printf("finished %d games under 500\n", losses - wins);
				} else if (wins > G / 2.0) {
					System.out.printf("finished %d games over 500\n", wins - losses);
				} else {
					System.out.println("finished at 500");
				}
			}
			System.out.println();
		}
	}
}
