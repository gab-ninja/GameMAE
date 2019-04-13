package MAE;

public class Monk extends Hero {
	private static final double PROB_DODGE = 0.33; 

	public Monk(String name, Categories category, int healthMax, int attackMin, int attackMax, String imgName) {
		super(name, category, healthMax, attackMin, attackMax, imgName);
	}

	@Override
	public String takeDamage(int damage, Character attacker) {
		if (Math.random() > PROB_DODGE) {
			return super.takeDamage(damage, attacker);
		}
		return "On an amazing move, " + this.name + " doged the attack from " + attacker.name + " completely";
	}
}
