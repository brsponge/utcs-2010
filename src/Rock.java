import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Rock {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("rock.dat"));
		String[] outcomes = new String[] {
				"Scissors CUTS Paper",
				"Paper COVERS Rock",
				"Rock CRUSHES Lizard",
				"Lizard POISONS Spock",
				"Spock SMASHES Scissors",
				"Scissors DECAPITATES Lizard",
				"Lizard EATS Paper",
				"Paper DISPROVES Spock",
				"Spock VAPORIZES Rock",
				"Rock CRUSHES Scissors"
		};
		HashMap<String, String> map = new HashMap<>();
		map.put("*********", "Rock");
		map.put("---***---", "Paper");
		map.put("**---***-", "Scissors");
		map.put("-***-*-*-", "Lizard");
		map.put("*-**-*-*-", "Spock");
		int N = scanner.nextInt();
		for (int i = 0; i < N; i++) {
			int G = scanner.nextInt();
			int player1 = 0;
			int player2 = 0;
			int ties = 0;
			System.out.printf("Game %d: \n", i + 1);
			for (int j = 0; j < G; j++) {
				String a = "";
				String b = "";
				for (int k = 0; k < 3; k++) {
					a += scanner.next();
					b += scanner.next();
				}
				if (!map.containsKey(a) && !map.containsKey(b)) {
					ties++;
					System.out.println("Both players picked invalid weapons. Tie.");
				} else if (!map.containsKey(a)) {
					player2++;
					System.out.println("Player 1 picked an invalid weapon. Player 2 wins.");
				} else if (!map.containsKey(b)) {
					player1++;
					System.out.println("Player 2 picked an invalid weapon. Player 1 wins.");
				} else if (a.equals(b)) {
					ties++;
					System.out.printf("Both players picked %s. Tie.\n", map.get(a));
				} else {
					String move = "";
					for (int l = 0; l < outcomes.length; l++) {
						if (outcomes[l].contains(map.get(a)) && outcomes[l].contains(map.get(b))) {
							move = outcomes[l];
							break;
						}
					}
					boolean aWinner = move.indexOf(map.get(a)) < move.indexOf(map.get(b));
					System.out.printf("%s. %s wins.\n", move, aWinner ? "Player 1" : "Player 2");
					if (aWinner)
						player1++;
					else
						player2++;
				}
			}
			System.out.printf("Player 1: %d, Player 2: %d, Ties: %d. Result: %s\n", player1, player2, ties,
					player1 > player2 ? "Player 1 wins." : (player2 < player1 ? "Player 2 wins." : "Tie."));
		}
	}
}
