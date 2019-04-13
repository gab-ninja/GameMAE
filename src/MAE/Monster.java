package MAE;

import java.util.ArrayList;
import java.util.Collections;

public class Monster extends Character {
	private static final int TIME_BEFORE_ATTACK = 1000;
	private static final int TIME_AFTER_ATTACK = 2000;
	
	private final int coins;

	public Monster(String name, Categories category, int healthMax, int attackMin, int attackMax, String imgName, int coins) {
		super(name, category, healthMax, attackMin, attackMax, imgName, true);
		this.coins = coins;
	}
	
	public int getCoins() {
		return this.coins;
	}

	@Override
	public void play(GI_Battle playerInterface) {
		playerInterface.setComputerPlaying(this);
		if (this.canPlay && this.isAlive()) {
			try {
				Thread.sleep(TIME_BEFORE_ATTACK);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ArrayList <Character> toAttack = new ArrayList <Character>();
			toAttack.addAll(playerInterface.getHuman().getCharactersToAttack());
			Collections.shuffle(toAttack);
			String res = this.attack(toAttack.get(0), playerInterface);
			playerInterface.setCPUstatus(res);
			playerInterface.setHeroAttacked(toAttack.get(0));
			try {
				Thread.sleep(TIME_AFTER_ATTACK);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}