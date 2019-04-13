package MAE;

public abstract class Item {
	protected int price;
	protected String name;
	protected String image;
	protected boolean canBeSaved;

	public Item(int price, String name, String image) {
		this.price = price;
		this.name = name;
		this.image = image;
		this.canBeSaved = true;
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
}
