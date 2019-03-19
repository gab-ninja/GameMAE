package MAE;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Game {
	
	private ArrayList <Character> heroes = new ArrayList<Character>();
	private ArrayList <Character> monsters = new ArrayList<Character>();
	private ArrayList <Character> order = new ArrayList <Character>();

	private PlayerInterface gameInterface;
	private Human human;
	private Computer cpu;
	
	private static ArrayUtils arr= new ArrayUtils();
	
	public Game() {
		super();
		this.readCharacters();
	}

	public void startGame() {
		this.gameInterface = new PlayerInterface();
		
		int[] numbersChosen = gameInterface.pickHeroes(heroes);
		this.human = new Human(this.convertInt2Character(numbersChosen, true));
		
		int[] cpuTeam = arr.randomNonRepetitive(4, monsters.size());
		this.cpu = new Computer(this.convertInt2Character(cpuTeam, false));
		
		gameInterface.showStats(human.getCharacters(), cpu.getCharacters());
		
		order.addAll(this.human.getCharacters());
		order.addAll(this.cpu.getCharacters());
		
		boolean isPlaying = true;
		while (isPlaying) {
			Collections.shuffle(this.order);
			for (Character character : order) {
				if (!human.hasCharactersAlive()) {
					//Human lost
					isPlaying = false;
					break;
				}
				if (!cpu.hasCharactersAlive()) {
					isPlaying = false;
					break;
					//CPU lost
				}
				if (character.canPlay()) {
					if (character.isMonster()) {
						this.computerAttack(character);
					} else {
						this.playerAttack(character);
					}
					gameInterface.showStats(human.getCharacters(), cpu.getCharacters());
				}
			}
		}
		gameInterface.closeGame();
	}
	
	public void playerAttack(Character character) {
		Character toAttack;
        if (character.isCleric()) {
        	toAttack = this.gameInterface.selectToAttack(character, this.human.getCharactersAlive());        	
        } else {
        	toAttack = this.gameInterface.selectToAttack(character, this.cpu.getCharactersAlive());
        }
        int damage = character.attack(toAttack);
        gameInterface.showAttack(damage, character, toAttack);
        
	}
	
	public void computerAttack(Character character) {
		ArrayList <Character> toAttack = new ArrayList <Character>();
		toAttack.addAll(this.human.getCharactersAlive());
		Collections.shuffle(toAttack);
		int damage = character.attack(toAttack.get(0));
		
        gameInterface.showAttack(damage, character, toAttack.get(0));
	}
	
	public void readCharacters()  {
		try {
			String cwd = new File("").getAbsolutePath();
	        Scanner scanner = new Scanner(new File(cwd + "/src/MAE/characters.csv"));
	        scanner.useDelimiter("\n");
	        while(scanner.hasNext()){
	        	String[] read =  scanner.next().toString().split(",");
	        	//TODO: verify if the provided categories are inside the enum
	        	switch (read[0]) {
		        	case "hero":
		        		heroes.add(new Character(read[1], categories.valueOf(read[2]), Integer.parseInt(read[3]), Integer.parseInt(read[4]), Integer.parseInt(read[5]), false));
		        		break;
		        	case "specialHero":
		        		heroes.add(new SpecialCharacter(read[1], categories.valueOf(read[2]), Integer.parseInt(read[3]), Integer.parseInt(read[4]), Integer.parseInt(read[5]), false));
		        		break;
		        	case "monster":
		        		monsters.add(new Character(read[1], categories.valueOf(read[2]), Integer.parseInt(read[3]), Integer.parseInt(read[4]), Integer.parseInt(read[5]), true));
		        		break;
	        	}
	        	
	        }
	        scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Characters file is missing");
			e.printStackTrace();
		}
    }
	
	private ArrayList <Character> convertInt2Character(int[] arr, boolean isHero) {
		ArrayList <Character> characters = new ArrayList<Character>();
		for (int i=0; i<arr.length; i++) {
			if (isHero) {
				characters.add(heroes.get(arr[i]));
			} else {
				characters.add(monsters.get(arr[i]));
			}
		}
		return characters;
	}
};
