package MAE;

public class Monk extends Character {

	public Monk(String name, categories category, int healthMax, int attackMin, int attackMax, boolean isMonster) {
		super(name, category, healthMax, attackMin, attackMax, isMonster);
	}

	@Override
	public boolean takeDamage(int damage, Character attacker) {
		if (Math.random() > 0.33) {
			return super.takeDamage(damage, attacker);
		}
		return false;
	}

	
}
