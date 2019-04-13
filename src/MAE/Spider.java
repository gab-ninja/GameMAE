package MAE;

public class Spider extends Monster {
	private static final int MAX_TURNS_TO_POISON = 3; 
	
	public Spider(String name, Categories category, int healthMax, int attackMin, int attackMax, String imgName, int coins) {
		super(name, category, healthMax, attackMin, attackMax, imgName, coins);
	}

	@Override
	public String attack(Character defender, GI_Battle playerInterface) {
		defender.poison((int) Math.random() * MAX_TURNS_TO_POISON + 1);
		return (super.attack(defender, playerInterface) + " and also, poisoned it!");
	}
}
