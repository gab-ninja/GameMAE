package MAE;

public class Duelist extends Hero {

	public Duelist(String name, Categories category, int healthMax, int attackMin, int attackMax, String imgName) {
		super(name, category, healthMax, attackMin, attackMax, imgName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play(GI_Battle playerInterface) {
		super.play(playerInterface);
		playerInterface.updateStats();
		if (playerInterface.getCPU().hasCharactersAlive()) {			
			super.play(playerInterface);
		}
	}

	
}
