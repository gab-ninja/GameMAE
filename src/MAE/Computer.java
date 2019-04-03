package MAE;

import java.util.ArrayList;

public class Computer extends Player {
	private ArrayList <Character> monsters = new ArrayList<Character>();
	
	private static ArrayUtils au = new ArrayUtils();
	
	public Computer() {
		super();
		for (Monsters monster : Monsters.values()) {
			this.monsters.add(monster.generateCharacterObject());
		}
	}
	
	@Override
	public void setInterface(GI_Battle playerInterface) {
		super.setInterface(playerInterface);
		this.playerInterface.setCPU(this);
	}

	public ArrayList<Character> generateTeam(int level) {
		int numOfMonsters = level>2 ? 4 : 3;
		ArrayList <Character> characters = new ArrayList<Character>();
		int[] cpuTeam = au.randomNonRepetitive(numOfMonsters, this.monsters.size());
		for (int i=0; i<cpuTeam.length; i++) {
			characters.add(monsters.get(cpuTeam[i]));
		}
		this.setTeam(characters);
		this.playerInterface.loadMonsters(this.team);
		return this.team;
		
	}
	
	public ArrayList<Character> getCharactersToAttack() {
		return this.getCharactersAlive();
	}

	public void play(int level) {
		System.out.println(level);
	}
};
