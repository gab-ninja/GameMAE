package MAE;

public class Slime extends Monster {

	public Slime(String name, Categories category, int healthMax, int attackMin, int attackMax, String imgName) {
		super(name, category, healthMax, attackMin, attackMax, imgName);
	}

	@Override
	public String attack(Character defender, GI_Battle playerInterface) {
		defender.block();
		return (super.attack(defender, playerInterface) + " and also blocked " + defender.name + " from playing on his next round");
	}
	
	

}
