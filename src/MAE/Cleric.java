package MAE;

public class Cleric extends Hero {

	public Cleric(String name, Categories category, int healthMax, int attackMin, int attackMax, String imgName) {
		super(name, category, healthMax, attackMin, attackMax, imgName);
	}

	@Override
	public boolean isCleric() {
		return true;
	}

	@Override
	public void play(GI_Battle playerInterface) {
		System.out.println("cleric is playing");
	}
	
	

}
