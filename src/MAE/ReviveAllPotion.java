package MAE;

import java.util.ArrayList;

public class ReviveAllPotion extends Item{
	
	public ReviveAllPotion(int price, String name, String image) {
		super(price, name, image);
	}
	
	public void execute(Game game) {
		game.getHuman().healTeam();
	}

	@Override
	public void receiveHero(Hero hero) {
		// TODO Auto-generated method stub
		
	}

}
