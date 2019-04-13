package MAE;

import java.util.ArrayList;

public abstract class Item {
	protected int price;
	protected String name;
	protected String image;

	public Item(int price, String name, String image) {
		this.price = price;
		this.name = name;
		this.image = image;
	}

	public int getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	public String getImage() {
		return image;
	}
	
	public abstract void execute(Game game);
	
	public abstract void receiveHero(Hero hero);

	@Override
	public String toString() {
		return name;
	}
	
	
}
