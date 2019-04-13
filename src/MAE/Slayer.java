package MAE;

public class Slayer extends Monster{
	public static final double ATTACK_LOWER = 0.1;

	public Slayer(String name, Categories category, int healthMax, int attackMin, int attackMax, String imgName, int coins) {
		super(name, category, healthMax, attackMin, attackMax, imgName, coins);
	}

	@Override
	public String attack(Character defender, GI_Battle playerInterface) {
		defender.lowerAttack(ATTACK_LOWER);
		playerInterface.setHeroAttack("Attack lowered to " + defender.getAttackMin() + "/" + defender.getAttackMax(), defender);
		return super.attack(defender, playerInterface) + " and also lowered his attack in " + ATTACK_LOWER * 100  + "%" ;
	}
}
