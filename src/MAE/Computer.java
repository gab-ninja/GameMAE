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
		ArrayList <Character> characters = new ArrayList<Character>();
		ArrayList <Character> team= new ArrayList<Character>();
	
		for (Character monster: this.monsters) { 
			Categories cat = monster.getCategory();
			if (level == 1 && (cat == Categories.Spider || cat == Categories.Mummy || cat == Categories.Slime)) {
				characters.add(monster);
			}
			else if (level == 2 && (cat == Categories.Spider || cat == Categories.Mummy || cat == Categories.Slime || cat == Categories.Karim)) {
				characters.add(monster);
			}
			else if (level == 3 && (cat == Categories.Karim || cat == Categories.Mummy || cat == Categories.Slime)) {
				characters.add(monster);
			}
			else if (level == 4 && (cat == Categories.Karim || cat == Categories.Mummy || cat == Categories.Slime || cat == Categories.Avenger)) {
				characters.add(monster);
			}
			else if (level == 5 && (cat == Categories.Avenger || cat == Categories.Slayer || cat == Categories.Karim)) {
				characters.add(monster);
			}
			else if (level > 5) {
				characters.add(monster);
			}
		}
						
		int numOfMonsters = level>2 ? 4 : 3;
		int[] cpuTeam = au.randomNonRepetitive(numOfMonsters, characters.size());
		
		for (int i=0; i<cpuTeam.length; i++) {
			team.add(characters.get(cpuTeam[i]));
		}
		this.setTeam(team);
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
