package MAE;

public class Mummy extends Monster {
	
	private boolean canPlay;

	public Mummy(String name, Categories category, int healthMax, int attackMin, int attackMax, String imgName) {
		super(name, category, healthMax, attackMin, attackMax, imgName);
		this.canPlay = true;
	}

	@Override
	public void play(GI_Battle playerInterface) {
		if (this.canPlay) {
			super.play(playerInterface);
		}
		this.canPlay = !this.canPlay;
	}
	
	

}
