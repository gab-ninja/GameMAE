package MAE;

public enum Items {
	Revive_100 (CategoriesItems.RevivePotion, 15, "/i1.png", 100),
	Attack_40 (CategoriesItems.AttackPotion, 200, "/i2.png",40),
	Revive_All (CategoriesItems.ReviveAll, 400, "/i3.png",0);

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
