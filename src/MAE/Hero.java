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
			System.out.println("waitting for monster to attack");
			while(this.monsterToAttack == null) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("monster to attack " + this.monsterToAttack);
			this.attack(this.monsterToAttack);
		} else if (!this.canPlay && this.isAlive()) {
			this.unBlock();
		}
	}
	
	public void setMonsterToAttack(Character monsterToAttack) {
		this.monsterToAttack = monsterToAttack;
	}
}

/*
public void playerAttack(Character character) {
	Character toAttack;
   if (character.isCleric()) {
   	toAttack = this.gameInterface.selectToAttack(character, this.human.getCharactersAlive());        	
   } else {
   	toAttack = this.gameInterface.selectToAttack(character, this.cpu.getCharactersAlive());
   }
   int damage[] = character.attack(toAttack);
   gameInterface.showAttack(damage, character, toAttack);
   
}
*/
