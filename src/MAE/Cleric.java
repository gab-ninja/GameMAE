package MAE;

public class Cleric extends Hero {

	public Cleric(String name, Categories category, int healthMax, int attackMin, int attackMax, String imgName) {
		super(name, category, healthMax, attackMin, attackMax, imgName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isCleric() {
		return true;
	}

}
