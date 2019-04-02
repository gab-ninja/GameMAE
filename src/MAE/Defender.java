package MAE;

public class Defender extends Hero {

	public Defender(String name, Categories category, int healthMax, int attackMin, int attackMax, String imgName) {
		super(name, category, healthMax, attackMin, attackMax, imgName);
	}

	@Override
	public boolean isDefender() {
		return true;
	}
	
	@Override
	public boolean takeDamage(int damage, Character attacker) {
		super.takeDamage(damage, attacker);
		if(this.isAlive()) {
			this.attack(attacker);
		}
		return true;
	}
}