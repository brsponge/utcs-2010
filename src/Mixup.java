import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Mixup {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("mixup.dat"));
		int N = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < N; i++) {
			Scanner sc = new Scanner(scanner.nextLine());
			while (sc.hasNext()) {
				StringBuilder sb = new StringBuilder(sc.next());
				System.out.print(sb.reverse() + " ");
			}
			System.out.println();
		}
	}
}
