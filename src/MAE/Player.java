package MAE;


public class Player {

	private int damageGiven;
	private int damageTaken;
	protected Character[] characters;

	public Player(Character[] characters) {
		this.characters = characters;
		this.damageGiven = 0;
		this.damageTaken = 0;
	}
};
