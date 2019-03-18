package MAE;
import java.util.*;

public class PlayerInterface {
	public PlayerInterface() {
		System.out.println("Game started...");
	}

	public void beginGame() {
	}

	public void showStats(ArrayList <Character> heroes, ArrayList <Character> monsters) {
		System.out.println("-----------------------------------------------------------------------------------");
		for (int i=0; i < heroes.size(); i++) {
			if (i < monsters.size()) {
				System.out.printf("| %s \t| %s \t |\n", heroes.get(i).toString(), monsters.get(i).toString());
			} else {
				System.out.printf("| %s \t| \t\t\t\t \t |\n", heroes.get(i).toString());
			}
		}
		System.out.println("-----------------------------------------------------------------------------------");
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
			if(arr.contains(heroesChoice, choice) || choice > (heroes.size()-1) || choice < 0) {
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
