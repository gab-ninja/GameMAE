package MAE;
import java.util.*;

public class PlayerInterface {
	
	Scanner scanner = new Scanner(System.in);
	
	public PlayerInterface() {
		System.out.println("Mists of the Abandoned Etherdungeon!!! Game started...");
	}

	public void beginGame() {
	}
	
	public void showLevel(int level) {
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.printf("\t LEVEL: %d  \n", level);
		System.out.println("-----------------------------------------------------------------------------------");
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
	
	public void closeGame(boolean result) {
		this.scanner.close();
		System.out.println(result ? "You Won :)" : "You Lost :(");
	}
	
	public void showAttack(int damage[], Character attacker, Character defender) {
		if (damage[0] == -1) {
			System.out.printf("\n%s DODGED ATTACK of %s \n\n", defender.getName(), attacker.getName());
			return;
		}
		if (defender.isDefender()) {
			System.out.printf("\n%s ATTACK %s for %d HP and %s hit back %s for %d HP\n\n", 
					attacker.getName(), defender.getName(), damage[0], defender.getName(), 
					attacker.getName(), damage[1]);
			return;
		}
		
		String type = attacker.isCleric() ? "HEAL" : "ATTACK";
		if (attacker.isCleric()) {
			damage[0] *= -1;
		}
		System.out.printf("\n%s %s %s for %d HP\n\n", attacker.getName(), type, defender.getName(), damage[0]);
	}
	
	public Character selectToAttack(Character attacker, ArrayList <Character> toAttack) {
		String type = "ATTACK";
		if (attacker.isCleric()) {
			type = "HEAL";
		}
		System.out.printf("Who will %s %s ?\n", attacker.getName(), type);
		for (int i=0; i < toAttack.size(); i++) {
			System.out.printf("[%d] %s\n", i,toAttack.get(i).getName());
		}
		int choice = -1;
		while(choice < 0 || choice > toAttack.size()) {
			System.out.printf("Insert an integer number between 0 and %d\n", toAttack.size()-1);
			choice = this.scanner.nextInt();			
		}
		return toAttack.get(choice);
	}

	public int[] pickHeroes(ArrayList <Character> heroes) {
		int[] heroesChoice = {-1, -1, -1, -1};
		ArrayUtils arr= new ArrayUtils();
		int choice;
		for (int i=0; i<4; i++) {
			for (int j=0; j< heroes.size(); j++) {
				if (arr.contains(heroesChoice, j)) {
					continue;
				} 
				System.out.printf("%d: %s \n", j, heroes.get(j).stats());
				
			}
			System.out.println("Pick an hero, " + (4-i) + " left");
			choice = this.scanner.nextInt();
			if(arr.contains(heroesChoice, choice) || choice > (heroes.size()-1) || choice < 0) {
				System.out.println("Character already taken, please chose another one");
				i--;
			} else {
				heroesChoice[i] = choice;				
			}
		}
		return heroesChoice;
	}
	
};
