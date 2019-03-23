package MAE;

public class Berserker extends Character {

	public Berserker(String name, categories category, int healthMax, int attackMin, int attackMax, boolean isMonster) {
		super(name, category, healthMax, attackMin, attackMax, isMonster);
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
