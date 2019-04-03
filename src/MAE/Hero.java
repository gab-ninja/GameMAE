package MAE;


public class Hero extends Character {
	private Character monsterToAttack;
	
	public Hero(String name, Categories category, int healthMax, int attackMin, int attackMax, String imgName) {
		super(name, category, healthMax, attackMin, attackMax, imgName, false);
	}

	@Override
	public void play(GI_Battle playerInterface) {
		playerInterface.setHumanPlaying(this);
		if (this.canPlay && this.isAlive()) {
			this.monsterToAttack = null;
			playerInterface.getMonsterToAttack(this);
			// System.out.println("waitting for monster to attack");
			while(this.monsterToAttack == null) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			// System.out.println("monster to attack " + this.monsterToAttack);
			String result = this.attack(this.monsterToAttack);
			playerInterface.setHumanStatus(result);
		} else if (!this.canPlay && this.isAlive()) {
			this.unBlock();
			playerInterface.setHumanStatus(this.name + " is now unblocked and free to play");
		}
	}
	
	public void setMonsterToAttack(Character monsterToAttack) {
		this.monsterToAttack = monsterToAttack;
	}
}