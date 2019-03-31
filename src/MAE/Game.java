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
	
	private String playerName;
	
	private static ArrayUtils au= new ArrayUtils();
	
	public Game() {
		super();
		this.readCharacters();
	}

	public void startGame() {
		new GI_Landing(this);
		/*
		this.gameInterface = new PlayerInterface();
		
		int[] numbersChosen = gameInterface.pickHeroes(heroes);
		this.human = new Human(this.convertInt2Character(numbersChosen, true));
		
		boolean result = false;
		
		for (int i=1; i<=5; i++) {
			 result = level(i);
			if (result == false) {
				break;
			}
			this.human.healCharacters();
			this.cpu.healCharacters();
		}
		
		gameInterface.closeGame(result);
		*/
	}
	
	public void receivePlayerName(String playerName) {
		this.playerName = playerName;
		new GI_PickHeroes(this);
	}

	public void receivePlayerCharacters(int[] characters) {
		this.human = new Human(this.convertInt2Character(characters, true), this.playerName);
		System.out.println("Game initiated..." + characters);
	}
	
	public boolean level(int level) {
		int numOfMonsters = 3;
		if (level > 2) {
			numOfMonsters = 4;
		}
		gameInterface.showLevel(level);
		
		int[] cpuTeam = au.randomNonRepetitive(numOfMonsters, monsters.size());
		this.cpu = new Computer(this.convertInt2Character(cpuTeam, false));
		
		gameInterface.showStats(human.getCharacters(), cpu.getCharacters());
		
		order.addAll(this.human.getCharacters());
		order.addAll(this.cpu.getCharacters());
		
		while (true) {
			Collections.shuffle(this.order);
			int listSize = this.order.size();
			for (int i=0; i < listSize; i++) {
				if (order.get(i).isDuelist()) {
					order.add(i, order.get(i));
					i++;
					listSize ++;
				}
			}
			for (Character character : order) {
				if (!human.hasCharactersAlive()) {
					return false;
				}
				if (!cpu.hasCharactersAlive()) {
					return true;
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
		
	}
	
	public void playerAttack(Character character) {
		Character toAttack;
        if (character.isCleric()) {
        	toAttack = this.gameInterface.selectToAttack(character, this.human.getCharactersAlive());        	
        } else {
        	toAttack = this.gameInterface.selectToAttack(character, this.cpu.getCharactersAlive());
        }
        int damage[] = character.attack(toAttack);
        gameInterface.showAttack(damage, character, toAttack);
        
	}
	
	public void computerAttack(Character character) {
		ArrayList <Character> toAttack = new ArrayList <Character>();
		toAttack.addAll(this.human.getCharactersToAttack());
		Collections.shuffle(toAttack);
		int[] damage = character.attack(toAttack.get(0));
		
        gameInterface.showAttack(damage, character, toAttack.get(0));
	}
	
	public void readCharacters()  {
		try {
			String cwd = new File("").getAbsolutePath();
	        Scanner scanner = new Scanner(new File(cwd + "/src/MAE/characters.csv"));
	        scanner.useDelimiter("\n");
	        while(scanner.hasNext()){
	        	String[] read =  scanner.next().toString().split(",");
	        	switch (read[0]) {
		        	case "hero":
		        		heroes.add(new Character(read[1], categories.valueOf(read[2]), Integer.parseInt(read[3]), Integer.parseInt(read[4]), Integer.parseInt(read[5]), false));
		        		break;
		        	case "specialHero":
		        		switch (read[2]) {
		        		case "Rogue":
		        			heroes.add(new RogueSpider(read[1], categories.valueOf(read[2]), Integer.parseInt(read[3]), Integer.parseInt(read[4]), Integer.parseInt(read[5]), false));
		        			break;		
		        		case "Berserker":
		        			heroes.add(new Berserker(read[1], categories.valueOf(read[2]), Integer.parseInt(read[3]), Integer.parseInt(read[4]), Integer.parseInt(read[5]), false));
		        			break;
		        		case "Monk":
		        			heroes.add(new Monk(read[1], categories.valueOf(read[2]), Integer.parseInt(read[3]), Integer.parseInt(read[4]), Integer.parseInt(read[5]), false));
		        			break;
		        		case "Duelist":
		        		case "Defender":
		        			heroes.add(new Character(read[1], categories.valueOf(read[2]), Integer.parseInt(read[3]), Integer.parseInt(read[4]), Integer.parseInt(read[5]), false));
		        			break;
		        		}
		        		break;
		        	case "monster":
		        		switch (read[2]) {
			        	case "Spider":
			        		monsters.add(new RogueSpider(read[1], categories.valueOf(read[2]), Integer.parseInt(read[3]), Integer.parseInt(read[4]), Integer.parseInt(read[5]), true));
			        		break;
			        	case "Mummy":
			        		monsters.add(new Mummy(read[1], categories.valueOf(read[2]), Integer.parseInt(read[3]), Integer.parseInt(read[4]), Integer.parseInt(read[5]), true));
			        		break;
			        	case "Slime":
			        		monsters.add(new Slime(read[1], categories.valueOf(read[2]), Integer.parseInt(read[3]), Integer.parseInt(read[4]), Integer.parseInt(read[5]), true));
			        		break;
			        	case "Avenger":
			        		monsters.add(new Avenger(read[1], categories.valueOf(read[2]), Integer.parseInt(read[3]), Integer.parseInt(read[4]), Integer.parseInt(read[5]), true));
			        		break;
			        	case "Hamish":
			        		monsters.add(new Hamish(read[1], categories.valueOf(read[2]), Integer.parseInt(read[3]), Integer.parseInt(read[4]), Integer.parseInt(read[5]), true));
			        		break;
			        	case "Karim":
			        		monsters.add(new Karim(read[1], categories.valueOf(read[2]), Integer.parseInt(read[3]), Integer.parseInt(read[4]), Integer.parseInt(read[5]), true));
			        		break;
			        }
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
