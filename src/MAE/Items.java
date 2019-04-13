package MAE;

public enum Items {
	Revive (CategoriesItems.RevivePotion, 500, "/10.png", 150),
	Attack (CategoriesItems.AttackPotion, 500, "/11.png",40),
	All (CategoriesItems.ReviveAll, 500, "/12.png",0);

	private final CategoriesItems category;
	private final int price;
	private final int variable;
	private final String imgName;

	Items(CategoriesItems category, int price, String imgName, int variable){
		this.category = category;
		this.price = price;
		this.variable = variable;
		this.imgName = imgName;
	}
	
	public Item generateItemObject() {
		switch (this.category) {
			case RevivePotion:
				return new LifePotion(this.price, this.name(), this.imgName, this.variable);
			case AttackPotion:
				return new AttackPotion(this.price, this.name(), this.imgName, this.variable);
			case ReviveAll:
				return new ReviveAllPotion(this.price, this.name(), this.imgName);
			default:
				return new AttackPotion(this.price, this.name(), this.imgName, this.variable);
		}

	}

}
