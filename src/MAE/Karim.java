package MAE;

public class Karim extends Monster{
	private static final double PROB_REFLECT_ATTACK = 0.25;

	public Karim(String name, Categories category, int healthMax, int attackMin, int attackMax, String imgName, int coins) {
		super(name, category, healthMax, attackMin, attackMax, imgName, coins);
	}

	@Override
	public String takeDamage(int damage, Character attacker) {
		if (Math.random() > PROB_REFLECT_ATTACK) {
			return super.takeDamage(damage, attacker);
		}
		String res = attacker.takeDamage(damage, this);
		return "On an amazing move, " + this.name + " reflect the attack. " + res;
	}
}
