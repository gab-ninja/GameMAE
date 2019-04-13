package MAE;

import java.util.*;
import java.util.concurrent.CountDownLatch;

public class Game {	
	public final CountDownLatch latch = new CountDownLatch(1);
	
	private final int NUMBER_OF_LEVELS = 5;
	
	private ArrayList <Character> order = new ArrayList <Character>();
	private ArrayList <Item> items = new ArrayList <Item>();
	
	private Computer cpu;
	private Human human;
	private String playerName;
	
	private GI_Battle playerInterface;
	
	private boolean hasReceivedCharacters;
	private boolean hasFinishedShopping;
	
	
	public Game() {
		this.playerName = "";
		this.hasReceivedCharacters = false;
		for (Items item : Items.values()) {
			this.items.add(item.generateItemObject());
		}
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
			for (Character character : order) {
				this.playerInterface.updateStats();
				if (!human.hasCharactersAlive()) {
					Thread t2 = new Thread(new GI_Lose());
			        t2.start();
					return true;
				}
				if (!cpu.hasCharactersAlive()) {
					if (level == NUMBER_OF_LEVELS) {
						Thread t2 = new Thread(new GI_Win());
				        t2.start();
					} else {
						for (Character ch : order) {
							if (ch.isMonster()) {
								this.human.addCoins(((Monster) ch).getCoins());
							}
						}
						this.playerInterface.msgbox("The heroes defeated the monsters on this level and are now resting for the next one");
						this.playerInterface.setVisibility(false);
						Thread tStore = new Thread(new GI_Store(this, this.items, this.human));
						tStore.start();
						this.hasFinishedShopping = false;
						while (!this.hasFinishedShopping) {
					        try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						this.playerInterface.setVisibility(true);
					}
					return false;
				}
				character.play(this.playerInterface);
			}	
		}	
	}
	
	public Human getHuman() {
		return this.human;
	}
	
	public GI_Battle getInterface() {
		return this.playerInterface;
	}
	
	public void updateFromStore() {
		this.hasFinishedShopping = true;
	}
};
