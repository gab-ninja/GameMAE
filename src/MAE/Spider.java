package MAE;

public class Spider extends Character {
	
	public Spider(String name, Categories category, int healthMax, int attackMin, int attackMax, String imgName) {
		super(name, category, healthMax, attackMin, attackMax, imgName, true);
	}

	@Override
	public int[] attack(Character defender) {
		defender.poison((int) Math.random() * 3 + 1);
		return super.attack(defender);
	}
	
	

}
