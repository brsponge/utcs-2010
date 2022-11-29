import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Towers {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("towers.dat"));
		int N = scanner.nextInt();
		for (int i = 0; i < N; i++) {
			int T = scanner.nextInt();
			int S = scanner.nextInt();
			int[] blocks = new int[S];
			for (int j = 0; j < S; j++) {
				blocks[j] = scanner.nextInt();
			}
			int[] towers = new int[T];
			int value = maxEqualTowers(0, towers, blocks);
			System.out.printf("Data Set %d Maximum Possible Height %d\n", i + 1, value);
		}
	}

	private static int maxEqualTowers(int index, int[] towers, int[] blocks) {
		if (index == blocks.length) {
			for (int i = 0; i < towers.length - 1; i++) {
				if (towers[i] != towers[i + 1])
					return 0;
			}
			return towers[0];
		}
		int max = 0;
		for (int i = 0; i < towers.length; i++) {
			towers[i] += blocks[index];
			max = Math.max(maxEqualTowers(index + 1, towers, blocks), max);
			towers[i] -= blocks[index];
		}
		max = Math.max(maxEqualTowers(index + 1, towers, blocks), max);
		return max;
	}
}
