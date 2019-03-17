package MAE;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Game {
	
	private ArrayList <Character> heroes = new ArrayList<Character>();
	private ArrayList <Character> monsters = new ArrayList<Character>();

	public Player[] player;

	public PlayerInterface playerinterface;

	public void startGame() {
		
	}
	
	private Character[] convertInt2Heroes(int[] arr) {
		Character[] characters = new Character[arr.length];
		for (int i=0; i<arr.length; i++) {
			characters[i] = heroes.get(arr[i]);
		}
		return characters;
	}

	public Game() {
		super();
		this.readCharacters();
		PlayerInterface gameInterface = new PlayerInterface();
		int[] numbersChosen = gameInterface.pickHeroes(heroes);
		Human human = new Human(this.convertInt2Heroes(numbersChosen));
		
		
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
};
