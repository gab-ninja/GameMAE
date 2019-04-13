package MAE;

public class Duelist extends Hero {
	public Duelist(String name, Categories category, int healthMax, int attackMin, int attackMax, String imgName) {
		super(name, category, healthMax, attackMin, attackMax, imgName);
	}

	@Override
	public void play(GI_Battle playerInterface) {
		playerInterface.setHumanPlaying(this);
		if (this.canPlay && this.isAlive()) {
			super.play(playerInterface);
			playerInterface.updateStats();
			if (playerInterface.getCPU().hasCharactersAlive()) {			
				super.play(playerInterface);
			}
		} else if (!this.canPlay && this.isAlive()) {
			this.unBlock();
			playerInterface.setHumanStatus(this.name + " is now unblocked and free to play");
		}
	}
}
