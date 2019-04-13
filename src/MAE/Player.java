package MAE;
import java.util.*;

import MAE.Character;

abstract class Player {
	protected ArrayList <Character> team;
	protected GI_Battle playerInterface;

	public void setInterface(GI_Battle playerInterface) {
		this.playerInterface = playerInterface;
	}
	
	public ArrayList<Character> getTeam() {
		return this.team;
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
}
