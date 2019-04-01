package MAE;
import java.util.*;

abstract class Player {

	protected int damageGiven;
	protected int damageTaken;
	protected ArrayList <Character> team;
	
	protected GI_Battle playerInterface;

	public Player(GI_Battle playerInterface) {
		this.damageGiven = 0;
		this.damageTaken = 0;
		this.playerInterface = playerInterface;
	}
	
	public void setTeam(ArrayList <Character> characters) {
		this.team = characters;
	}

	public int getDamageGiven() {
		return damageGiven;
	}

	public int getDamageTaken() {
		return damageTaken;
	}

	public ArrayList<Character> getTeam() {
		return team;
	}
	
	public ArrayList<Character> getCharactersAlive() {
		ArrayList <Character> charactersAlive = new ArrayList<Character>();
		charactersAlive.addAll(this.team);
		charactersAlive.removeIf(s -> !s.isAlive());
		return charactersAlive;
	}
	
	public ArrayList<Character> getCharactersToAttack() {
		ArrayList <Character> charactersToAttack = new ArrayList<Character>();
		charactersToAttack = this.getCharactersAlive();
		int listSize = charactersToAttack.size();
		for (int i=0; i < listSize; i++) {
			if (charactersToAttack.get(i).isDefender()) {
				charactersToAttack.add(i, charactersToAttack.get(i));
				i++;
				listSize ++;
			}
		}
		return charactersToAttack;
	}
	
	public boolean hasCharactersAlive() {
		return this.team.stream().anyMatch(e -> e.isAlive());
	}
	
	public void healTeam ()  {
		this.team.forEach(character ->  character.heal());
	}	
};
