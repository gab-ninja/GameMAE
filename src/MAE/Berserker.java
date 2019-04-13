package MAE;

public class Berserker extends Hero {
	private static final int HEAL_WHEN_FINISH = 80;

	public Berserker(String name, Categories category, int healthMax, int attackMin, int attackMax, String imgName) {
		super(name, category, healthMax, attackMin, attackMax, imgName);
	}

	@Override
	public String attack(Character defender, GI_Battle playerInterface) {
		String attack = super.attack(defender, playerInterface);
		if (!defender.isAlive()) {
			int initialHealth =  this.health;
			this.heal(HEAL_WHEN_FINISH);
			attack += ", since " + this.name + " finished the monster, it recovered " + 
					  (this.health - initialHealth) + "HP's";
		}
		return attack;
	}	
}
