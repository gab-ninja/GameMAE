package MAE;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Game {
	
	private ArrayList <Character> heroes = new ArrayList<Character>();
	private ArrayList <Character> monsters = new ArrayList<Character>();

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
		        		heroes.add(new Character(read[1], categories.valueOf(read[2]), Integer.parseInt(read[3]), Integer.parseInt(read[4]), Integer.parseInt(read[5])));
		        		break;
		        	case "specialHero":
		        		heroes.add(new SpecialCharacter(read[1], categories.valueOf(read[2]), Integer.parseInt(read[3]), Integer.parseInt(read[4]), Integer.parseInt(read[5])));
		        		break;
		        	case "monster":
		        		monsters.add(new Character(read[1], categories.valueOf(read[2]), Integer.parseInt(read[3]), Integer.parseInt(read[4]), Integer.parseInt(read[5])));
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
