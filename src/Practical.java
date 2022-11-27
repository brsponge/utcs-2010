import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class Practical {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("practical.dat"));
		int N = scanner.nextInt();
		for (int i = 0; i < N; i++) {
			int n = scanner.nextInt();
			TreeSet<Integer> treeSet = new TreeSet<>();
			for (int j = 1; j <= n / 2; j++) {
				if (n % j == 0)
					treeSet.add(j);
			}
			boolean practical = true;
			for (int j = 1; j < n; j++) {
				TreeSet<Integer> t = new TreeSet<>(treeSet);
				int temp = j;
				while (temp > 0 && t.floor(temp) != null) {
					int x = t.floor(temp);
					t.remove(x);
					temp -= x;
				}
				if (temp != 0) {
					practical = false;
					break;
				}
			}
			if (practical)
				System.out.println("PRACTICAL");
			else
				System.out.println("NOT PRACTICAL");
		}
	}
}
