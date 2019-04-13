package MAE;

public class Cleric extends Hero {
	private Hero heroToHeal;
	
	public Cleric(String name, Categories category, int healthMax, int attackMin, int attackMax, String imgName) {
		super(name, category, healthMax, attackMin, attackMax, imgName);
	}

	@Override
	public boolean isCleric() {
		return true;
	}
	
	public String healTeammate(Hero hero) {
		if (this.isPoisoned()) {
			this.takeDamage(POISON_DAMAGE, this);
			this.poison --;
			if(!this.isAlive()) {
				return "Unfortunatley, " + this.name + " died due to the poison" ;
			}
		}
		int heal = this.attackMin + (int)(Math.random() * ((this.attackMax - this.attackMin) + 1));
		heal = hero.heal(heal);
		return (this.name + " healed " + hero.getName() + " for " + heal + "HP's");
	}

	@Override
	public void play(GI_Battle playerInterface) {
		playerInterface.setHumanPlaying(this);
		if (this.canPlay && this.isAlive()) {
			this.heroToHeal = null;
			playerInterface.getHeroToHeal(this);
			while(this.heroToHeal == null) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			playerInterface.setHumanStatus(this.healTeammate(this.heroToHeal)); 
		} else if (!this.canPlay && this.isAlive()) {
			this.unBlock();
			playerInterface.setHumanStatus(this.name + " is now unblocked and free to play");
		}
	}
	
	public void setHeroToHeal(Hero hero) {
		this.heroToHeal = hero;
	}
}
