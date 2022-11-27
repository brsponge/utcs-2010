import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Marbles {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("marbles.dat"));
		int N = scanner.nextInt();
		for (int i = 0; i < N; i++) {
			int r = scanner.nextInt();
			int c = scanner.nextInt();
			char[][] map = new char[r][c];
			for (int j = 0; j < r; j++) {
				map[j] = scanner.next().toCharArray();
			}
			HashSet<ArrayList<Integer>> coords = new HashSet<>();
			for (int j = 0; j < r; j++) {
				for (int k = 0; k < c; k++) {
					if (map[j][k] == 'm') {
						ArrayList<Integer> a = new ArrayList<>();
						a.add(j);
						a.add(k);
						coords.add(a);
					}
				}
			}
			int count = sim(map, coords);
			System.out.printf("Data Set %d %s %s\n", i + 1, count > 1 ? "NOT SOLVED" : "SOLVED",
					count > 1 ? count : "");
		}
	}

	private static int[] row = new int[] { 1, -1, 0, 0 };
	private static int[] col = new int[] { 0, 0, 1, -1 };

	private static int sim(char[][] map, HashSet<ArrayList<Integer>> coords) {
		if (coords.size() == 1)
			return 1;
		ArrayList<ArrayList<Integer>> list = new ArrayList<>(coords);
		int min = coords.size();
		for (ArrayList<Integer> save : list) {
			if (min == 1)
				break;
			coords.remove(save);
			int r = save.get(0);
			int c = save.get(1);
			map[r][c] = 'o';
			for (int i = 0; i < 4 && min > 1; i++) {
				if (r + row[i] * 2 >= map.length || r + row[i] * 2 < 0 || c + col[i] * 2 < 0
						|| c + col[i] * 2 >= map[r].length)
					continue;
				if (map[r + row[i]][c + col[i]] != 'm' || map[r + row[i] * 2][c + col[i] * 2] != 'o')
					continue;
				map[r + row[i]][c + col[i]] = 'o';
				map[r + 2 * row[i]][c + 2 * col[i]] = 'm';
				ArrayList<Integer> jumped = new ArrayList<Integer>();
				jumped.add(r + row[i]);
				jumped.add(c + col[i]);
				ArrayList<Integer> to = new ArrayList<Integer>();
				to.add(r + 2 * row[i]);
				to.add(c + 2 * col[i]);
				coords.remove(jumped);
				coords.add(to);
				min = Math.min(sim(map, coords), min);
				coords.add(jumped);
				coords.remove(to);
				map[r + row[i]][c + col[i]] = 'm';
				map[r + 2 * row[i]][c + 2 * col[i]] = 'o';
			}
			coords.add(save);
			map[r][c] = 'm';
		}
		return min;
	}
}
