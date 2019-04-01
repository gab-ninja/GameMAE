package MAE;

import java.util.concurrent.CountDownLatch;

public class Heroe extends Character {
	
	public Heroe(String name, Categories category, int healthMax, int attackMin, int attackMax, String imgName) {
		super(name, category, healthMax, attackMin, attackMax, imgName, false);
	}

	@Override
	public void play(GI_Battle playerInterface) {
		if (this.canPlay && this.health > 0) {
			int choice = playerInterface.getMonsterToAttack(this);
			System.out.println(choice);
		}
		return;
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
