package MAE;

public class Rogue extends Hero {
	private static final int MAX_TURNS_TO_POISON = 3; 
	
	public Rogue(String name, Categories category, int healthMax, int attackMin, int attackMax, String imgName) {
		super(name, category, healthMax, attackMin, attackMax, imgName);
	}

	@Override
	public String attack(Character defender,  GI_Battle playerInterface) {
		defender.poison((int) Math.random() * MAX_TURNS_TO_POISON + 1);
		return (super.attack(defender, playerInterface) + " and also, poisoned it!");
	}
	
	

}
