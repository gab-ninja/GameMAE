package MAE;
import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.swing.SwingUtilities;

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
	
	private boolean hasReceivedCharacters;
	
	
	public Game() {
		this.level = 0;
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
        }
        System.out.println("Game finished...");
        
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
		
		while(true) {
			Collections.shuffle(this.order);	
			System.out.println(order);
			for (Character character : order) {
				this.playerInterface.updateStats();
				if (!human.hasCharactersAlive()) {
					return true;
				}
				if (!cpu.hasCharactersAlive()) {
					return false;
				}
				character.play(this.playerInterface);
			}	
		}	
	}
};
