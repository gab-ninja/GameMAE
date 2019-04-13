package MAE;

public class ReviveAllPotion extends Item{
	
	public ReviveAllPotion(int price, String name, String image) {
		super(price, name, image);
		this.canBeSaved=false;
	}
	
	public void execute(GI_Battle battle) {
		battle.getHuman().healTeam();
	}

}
