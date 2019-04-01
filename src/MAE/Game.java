package MAE;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Game {
	
	public final CountDownLatch latch = new CountDownLatch(1);
	
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
		}
		System.out.println("Game finished...");
	}
	
	public boolean playLevel(int level) {
		order.clear();
		order.addAll(this.human.getTeam());
		order.addAll(this.cpu.generateTeam(level));
		while(true) {
			Collections.shuffle(this.order);
			for (Character character : order) {
				if (!human.hasCharactersAlive()) {
					return true;
				}
				if (!cpu.hasCharactersAlive()) {
					return false;
				}
				//character.play(this.playerInterface);
				return true;
			}
		}		
	}
};
