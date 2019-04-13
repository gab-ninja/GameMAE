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
	public String takeDamage(int damage, Character attacker) {
		String res = super.takeDamage(damage, attacker);
		if(this.isAlive()) {
			int attack = this.attackMin + (int)(Math.random() * ((this.attackMax - this.attackMin) + 1));
			res += ", and a hit back occured and " + attacker.takeDamage(attack, this);
		}
		return res;
	}
}