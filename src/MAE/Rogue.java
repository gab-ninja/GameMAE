package MAE;

public class Rogue extends Character {
	
	public Rogue(String name, Categories category, int healthMax, int attackMin, int attackMax) {
		super(name, category, healthMax, attackMin, attackMax, false);
	}

	@Override
	public int[] attack(Character defender) {
		defender.poison((int) Math.random() * 3 + 1);
		return super.attack(defender);
	}
	
	

}
