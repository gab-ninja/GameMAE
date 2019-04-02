package MAE;
import java.util.*;

import MAE.Character;

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

	public ArrayList<Character> getTeam() {
		return team;
	}

	public int getDamageGiven() {
		return damageGiven;
	}

	public int getDamageTaken() {
		return damageTaken;
	}

	public ArrayList<Character> getCharactersAlive() {
		ArrayList <Character> charactersAlive = new ArrayList<Character>();
		charactersAlive.addAll(this.team);
		charactersAlive.removeIf(s -> !s.isAlive());
		return charactersAlive;
	}
	
	public abstract ArrayList<Character> getCharactersToAttack();
	
	public boolean hasCharactersAlive() {
		return this.team.stream().anyMatch(e -> e.isAlive());
	}
	
	public void healTeam ()  {
		this.team.forEach(character ->  character.revive());
	}	
	
	public void setTeam(ArrayList <Character> characters) {
		this.team = characters;
	}
};
