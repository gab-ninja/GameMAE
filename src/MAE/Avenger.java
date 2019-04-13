package MAE;

public class Avenger extends Monster {
	private static final double PROB_CONVERT_TO_HEAL = 0.2;

	public Avenger(String name, Categories category, int healthMax, int attackMin, int attackMax, String imgName, int coins) {
		super(name, category, healthMax, attackMin, attackMax, imgName, coins);
	}
	
	@Override
	public String takeDamage(int damage, Character attacker) {
		if (Math.random() > PROB_CONVERT_TO_HEAL) {
			return super.takeDamage(damage, attacker);
		}
		this.heal(damage);
		return "On an amazing move, " + this.name + " transformed the attack of " + damage + "HP's from " + attacker.name + " into heal";
	}
}
