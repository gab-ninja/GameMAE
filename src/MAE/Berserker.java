package MAE;

public class Berserker extends Hero {

	public Berserker(String name, Categories category, int healthMax, int attackMin, int attackMax, String imgName) {
		super(name, category, healthMax, attackMin, attackMax, imgName);
	}

	@Override
	public String attack(Character defender) {
		String attack = super.attack(defender);
		if (!defender.isAlive()) {
			int initialHealth =  this.health;
			this.heal(40);
			attack += ", since " + this.name + " finished the monster, it recovered " + 
					  (this.health - initialHealth) + "HP's";
		}
		return attack;
	}

	
	
}
