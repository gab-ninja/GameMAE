package MAE;
import java.util.*;

public class Player {

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

	
	
};
