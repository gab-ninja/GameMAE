package MAE;

public class Slime extends Monster {

	public Slime(String name, Categories category, int healthMax, int attackMin, int attackMax, String imgName) {
		super(name, category, healthMax, attackMin, attackMax, imgName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int[] attack(Character defender) {
		defender.block();
		return super.attack(defender);
	}
	
	

}
