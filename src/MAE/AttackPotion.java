package MAE;

import java.util.ArrayList;

public class AttackPotion extends Item{
	private int benefit;
	private Hero hero;
	private boolean hasReceivedHero;
	
	public AttackPotion(int price, String name, String image,int benefit) {
		super(price, name, image);
		this.benefit=benefit;
	}
	
	public void execute(Game game) {
		this.hasReceivedHero = false;
		Thread t43 = new Thread(new GI_PickList(game.getHuman().getTeam(), this));
		t43.start();
		while (!this.hasReceivedHero) {
	        try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		hero.increaseAttack(this.benefit);
		game.getInterface().setHeroAttack("Attack increased to " + hero.getAttackMin() + "/" + hero.getAttackMax(), hero);
	}
	
	public void receiveHero(Hero hero) {
		this.hero = hero;
		this.hasReceivedHero = true;
	}
}
