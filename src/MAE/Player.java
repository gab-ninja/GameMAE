package MAE;
import java.util.*;

abstract class Player {

	private int damageGiven;
	private int damageTaken;
	protected ArrayList <Character> characters;

	public Player(ArrayList <Character> characters) {
		this.characters = characters;
		this.damageGiven = 0;
		this.damageTaken = 0;
	}

	public int getDamageGiven() {
		return damageGiven;
	}

	public int getDamageTaken() {
		return damageTaken;
	}

	public ArrayList<Character> getCharacters() {
		return characters;
	}
	
	public ArrayList<Character> getCharactersAlive() {
		ArrayList <Character> charactersAlive = new ArrayList<Character>();
		charactersAlive.addAll(this.characters);
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
		return this.characters.stream().anyMatch(e -> e.isAlive());
	}
	
	public void healCharacters ()  {
		this.characters.forEach(character ->  character.heal());
	}

	@Override
	public String toString() {
		return "Player [characters=" + characters + "]";
	}
	
	
	
};
