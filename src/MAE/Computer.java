package MAE;

import java.util.ArrayList;

public class Computer extends Player {
	private ArrayList <Character> monsters = new ArrayList<Character>();
	
	private static ArrayUtils au = new ArrayUtils();
	
	public Computer(GI_Battle playerInterface) {
		super(playerInterface);
		for (Monsters monster : Monsters.values()) {
			this.monsters.add(monster.generateCharacterObject());
		}
	}
	
	public ArrayList<Character> generateTeam(int level) {
		int numOfMonsters = level>2 ? 4 : 3;
		ArrayList <Character> characters = new ArrayList<Character>();
		int[] cpuTeam = au.randomNonRepetitive(numOfMonsters, this.monsters.size());
		for (int i=0; i<cpuTeam.length; i++) {
			characters.add(monsters.get(cpuTeam[i]));
		}
		this.setTeam(characters);
		return this.team;
		
	}

	public void play(int level) {
		System.out.println(level);
	}
};
