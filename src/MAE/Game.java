package MAE;
import java.util.*;

public class Game {
	
	private final int NUMBER_OF_LEVELS = 5;
	
	private ArrayList <Character> order = new ArrayList <Character>();
	private int level;
	
	private Computer cpu;
	private Human human;
	private String playerName;
	
	private PlayerInterface gameInterface;
	private GI_Battle playerInterface;
	
	public Game() {
		this.level = 0;
	}

	public void startGame() {
		new GI_Landing(this);
	}
	
	public void receivePlayerName(String playerName) {
		this.playerName = playerName;
		new GI_PickHeroes(this);
	}

	public void receivePlayerCharacters(ArrayList <Character> characters) {
		this.playerInterface = new GI_Battle(this);
		this.human = new Human(characters, this.playerName, this.playerInterface);
		this.cpu = new Computer(this.playerInterface);		
		
		boolean computerWon = false;
		for (int i=1; i<=NUMBER_OF_LEVELS; i++) {
			computerWon = playLevel(i);
			if (computerWon) {
				break;
			}
			this.human.healTeam();
			this.cpu.healTeam();
		}
		System.out.println("Game finished...");
	}
	
	public boolean playLevel(int level) {
		order.clear();
		order.addAll(this.human.getTeam());
		order.addAll(this.cpu.generateTeam(level));
		return true;
		/*
		while(true) {
			Collections.shuffle(this.order);
			for (Character character : order) {
				if (!human.hasCharactersAlive()) {
					return true;
				}
				if (!cpu.hasCharactersAlive()) {
					return false;
				}
				character.play();
			}
		}		
		*/
	}
	
	/*
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
	
	public void loadCharacters() {
		//TODO: reomve this method
		for (Heroes hero : Heroes.values()) {
			heroes.add(hero.generateCharacterObject());
		}
		for (Monsters monster : Monsters.values()) {
			monsters.add(monster.generateCharacterObject());
		}
	}
	
	private ArrayList <Character> convertInt2Heroes(int[] arr) {
		ArrayList <Character> characters = new ArrayList<Character>();
		for (int i=0; i<arr.length; i++) {
			characters.add(heroes.get(arr[i]));
		}
		return characters;
	}
	*/
};
