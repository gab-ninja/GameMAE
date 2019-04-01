package MAE;

public class Defender extends Heroe {

	public Defender(String name, Categories category, int healthMax, int attackMin, int attackMax, String imgName) {
		super(name, category, healthMax, attackMin, attackMax, imgName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isDefender() {
		return true;
	}

}
