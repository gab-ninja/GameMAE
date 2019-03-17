package MAE;
import java.util.*;

public class PlayerInterface {
	public PlayerInterface() {
		System.out.println("Game started...");
	}

	public void beginGame() {
	}

	public void showStats() {
	}

	public void attack() {
	}

	public int[] pickHeroes(ArrayList <Character> heroes) {
		int[] heroesChoice = {-1, -1, -1, -1, -1};
		ArrayUtils arr= new ArrayUtils();
		int choice;
		Scanner scanner = new Scanner(System.in);
		for (int i=0; i<5; i++) {
			for (int j=0; j< heroes.size(); j++) {
				if (arr.contains(heroesChoice, j)) {
					continue;
				} 
				System.out.printf("%d: %s \n", j, heroes.get(j).stats());
				
			}
			System.out.println("Pick an hero, " + (5-i) + " left");
			choice = scanner.nextInt();
			if(arr.contains(heroesChoice, choice)) {
				System.out.println("Character already taken, please chose another one");
				i--;
			} else {
				heroesChoice[i] = choice;				
			}
		}
		scanner.close();
		return heroesChoice;
	}
};
