package MAE;

public class Berserker extends Character {

	public Berserker(String name, Categories category, int healthMax, int attackMin, int attackMax, String imgName) {
		super(name, category, healthMax, attackMin, attackMax, imgName, false);
	}

	@Override
	public int[] attack(Character defender) {
		int[] attack = super.attack(defender);
		if (!defender.isAlive()) {
			this.takeDamage(-40, this);
		}
		return attack;
	}

	
	
}
