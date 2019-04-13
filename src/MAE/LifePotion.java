package MAE;

public class LifePotion extends Item{
	private int heal;
	
	public LifePotion(int price, String name, String image,int heal) {
		super(price, name, image);
		this.heal=heal;
	}
	
	public void execute(GI_Battle battle) {
		Hero hero = battle.askForHero();
		hero.heal(this.heal);
	}
}
