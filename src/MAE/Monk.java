package MAE;

public class Monk extends Character {

	public Monk(String name, Categories category, int healthMax, int attackMin, int attackMax, String imgName) {
		super(name, category, healthMax, attackMin, attackMax, imgName, false);
	}

	@Override
	public boolean takeDamage(int damage, Character attacker) {
		if (Math.random() > 0.33) {
			return super.takeDamage(damage, attacker);
		}
		return false;
	}

	
}
