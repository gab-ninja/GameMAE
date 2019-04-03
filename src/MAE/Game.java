package MAE;

import java.util.*;
import java.util.concurrent.CountDownLatch;

public class Game {
	
	public final CountDownLatch latch = new CountDownLatch(1);
	
	private final int NUMBER_OF_LEVELS = 5;
	
	private ArrayList <Character> order = new ArrayList <Character>();
	
	private Computer cpu;
	private Human human;
	private String playerName;
	
	private GI_Battle playerInterface;
	
	private boolean hasReceivedCharacters;
	
	
	public Game() {
		this.playerName = "";
		this.hasReceivedCharacters = false;
	}

	public void startGame() {
		Thread t1 = new Thread(new GI_Landing(this));
        t1.start();
        while (this.playerName.equals("")) {
	        try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
        
        Thread t2 = new Thread(new GI_PickHeroes(this));
        t2.start();
        while (!this.hasReceivedCharacters) {
	        try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
        
        this.playerInterface = new GI_Battle(this);
        Thread t3 = new Thread(this.playerInterface);
        t3.start();
        
        this.human.setInterface(this.playerInterface);
        this.cpu.setInterface(this.playerInterface);
        
        boolean computerWon = false;
        for (int i=1; i<=NUMBER_OF_LEVELS; i++) {
        	computerWon = playLevel(i);
        	if (computerWon) {
        		break;
        	}
        	this.human.healTeam();
        	this.cpu.healTeam();
        	this.playerInterface.setCPUstatus("");
        	this.playerInterface.setHumanStatus("All heroes were revived");
        }
        this.playerInterface.closeWindow();
        // System.out.println("Game finished...");
        
	}
	
	public void receivePlayerName(String playerName) {
		this.playerName = playerName;
	}

	public void receivePlayerCharacters(ArrayList <Character> characters) {
		this.human = new Human(characters, this.playerName);
		this.cpu = new Computer();	
		this.hasReceivedCharacters = true;	
	}
	
	public boolean playLevel(int level) {
		order.clear();
		order.addAll(this.human.getTeam());
		order.addAll(this.cpu.generateTeam(level));
		this.human.updateHeroes();
		
		while(true) {
			Collections.shuffle(this.order);	
			// System.out.println("ORDER: " + order);
			for (Character character : order) {
				this.playerInterface.updateStats();
				if (!human.hasCharactersAlive()) {
					this.playerInterface.msgbox(":( The CPU won. A great player is the one that never gives up!");
					return true;
				}
				if (!cpu.hasCharactersAlive()) {
					if (level == NUMBER_OF_LEVELS) {
						this.playerInterface.msgbox("Congratulations, " + this.human.getName() +" you won the game!");
					} else {
						this.playerInterface.msgbox("The heroes defeated the monsters on this level and are now resting for the next one");
					}
					return false;
				}
				character.play(this.playerInterface);
			}	
		}	
	}
};
