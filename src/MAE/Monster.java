package MAE;

import java.util.ArrayList;
import java.util.Collections;

public class Monster extends Character {
	
	private static final int ATTACK_TIME = 2300;

	public Monster(String name, Categories category, int healthMax, int attackMin, int attackMax, String imgName) {
		super(name, category, healthMax, attackMin, attackMax, imgName, true);
	}

	@Override
	public void play(GI_Battle playerInterface) {
		playerInterface.setComputerPlaying(this);
		if (this.canPlay && this.isAlive()) {
			try {
				Thread.sleep(ATTACK_TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ArrayList <Character> toAttack = new ArrayList <Character>();
			toAttack.addAll(playerInterface.getHuman().getCharactersToAttack());
			Collections.shuffle(toAttack);
			String res = this.attack(toAttack.get(0));
			playerInterface.setCPUstatus(res);
		}
	}
}