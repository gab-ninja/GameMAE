package MAE;

public class AttackPotion extends Item{
	private int benefit;
	
	public AttackPotion(int price, String name, String image,int benefit) {
		super(price, name, image);
		this.benefit=benefit;
	}
	
	public void execute(GI_Battle battle) {
		Hero hero = battle.askForHero();
		hero.increaseAttack(this.benefit);
	}
}
