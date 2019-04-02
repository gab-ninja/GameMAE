package MAE;

public class Rogue extends Hero {
	
	public Rogue(String name, Categories category, int healthMax, int attackMin, int attackMax, String imgName) {
		super(name, category, healthMax, attackMin, attackMax, imgName);
	}

	@Override
	public int[] attack(Character defender) {
		defender.poison((int) Math.random() * 3 + 1);
		return super.attack(defender);
	}
	
	

}
