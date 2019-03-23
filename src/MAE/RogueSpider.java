package MAE;

public class RogueSpider extends Character {
	
	public RogueSpider(String name, categories category, int healthMax, int attackMin, int attackMax, boolean isMonster) {
		super(name, category, healthMax, attackMin, attackMax, isMonster);
	}

	@Override
	public int[] attack(Character defender) {
		defender.poison((int) Math.random() * 3 + 1);
		return super.attack(defender);
	}
	
	

}
