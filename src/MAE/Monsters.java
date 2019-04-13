package MAE;

public enum Monsters {
	Hutt (Categories.Spider, 250, 80, 100, "/14.png", 50),
	Darth (Categories.Spider, 280, 70, 90, "/15.png", 50),
	Miraluka (Categories.Mummy, 500, 210, 230, "/16.png", 70),
	Mirialan (Categories.Mummy, 490, 215, 230, "/17.png", 70),
	Kaleesh (Categories.Slime, 260, 75, 90, "/18.png", 90),
	CodruJi (Categories.Slime, 270, 70, 90, "/19.png", 90),
	Goblin (Categories.Avenger, 600, 150, 170, "/20.png", 120),
	Bith (Categories.Avenger, 550, 160, 180, "/21.png", 120),
	Rodian (Categories.Slayer, 750, 200, 210, "/22.png", 180),
	Talz (Categories.Slayer, 700, 215, 225, "/23.png", 180),
	Yarkora (Categories.Karim, 800, 80, 90, "/24.png", 150),
	Cerean (Categories.Karim, 770, 90, 100, "/25.png", 150);
	
	private final Categories category;
	private final int hpMax;
	private final int attackMin;
	private final int attackMax;
	private final String imgName;
	private final int coins;

	Monsters(Categories category, int hp_max, int attack_min, int attack_max, String imgName, int coins){
		this.category = category;
		this.hpMax = hp_max;
		this.attackMin = attack_min;
		this.attackMax = attack_max;
		this.imgName = imgName;
		this.coins = coins;
	}
	
	public Character generateCharacterObject() {
		switch (this.category) {
		case Avenger:
			return new Avenger(this.toString(), this.category, this.hpMax, this.attackMin, this.attackMax, this.imgName, this.coins);
		case Karim:
			return new Karim(this.toString(), this.category, this.hpMax, this.attackMin, this.attackMax, this.imgName, this.coins);
		case Mummy:
			return new Mummy(this.toString(), this.category, this.hpMax, this.attackMin, this.attackMax, this.imgName, this.coins);
		case Slayer:
			return new Slayer(this.toString(), this.category, this.hpMax, this.attackMin, this.attackMax, this.imgName, this.coins);
    	case Slime:
    		return new Slime(this.toString(), this.category, this.hpMax, this.attackMin, this.attackMax, this.imgName, this.coins);
    	case Spider:
    		return new Spider(this.toString(), this.category, this.hpMax, this.attackMin, this.attackMax, this.imgName, this.coins);
		default:
			return new Monster(this.toString(), this.category, this.hpMax, this.attackMin, this.attackMax, this.imgName, this.coins);    		
		}
	}
}
