import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Fuel {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("fuel.dat"));
		int N = scanner.nextInt();
		for (int i = 0; i < N; i++) {
			System.out.printf("Data Set %d\n", i + 1);
			int days = scanner.nextInt();
			scanner.nextLine();
			ArrayList<Integer> data = new ArrayList<>();
			Scanner scanner2 = new Scanner(scanner.nextLine());
			while (scanner2.hasNextInt())
				data.add(scanner2.nextInt());
			int leaves = 0;
			int rfs = 0;
			int pdf = 0;
			for (int j = 0; j <= days; j++) {
				if (j >= 1)
					System.out.printf("Day %d %d%s", j, pdf, j < days ? ", " : "\n");
				pdf += rfs / 17;
				rfs %= 17;
				rfs += leaves / 177;
				leaves %= 177;
				if (j * 2 < data.size()) {
					leaves += data.get(j * 2) * data.get(j * 2 + 1) * 25;
				}
			}
		}
	}
}
