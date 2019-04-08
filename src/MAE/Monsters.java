package MAE;

public enum Monsters {
	Hutt (Categories.Spider, 250, 80, 100, "/14.png"),
	Darth (Categories.Spider, 280, 70, 90, "/15.png"),
	Miraluka (Categories.Mummy, 500, 210, 230, "/16.png"),
	Mirialan (Categories.Mummy, 490, 215, 230, "/17.png"),
	Kaleesh (Categories.Slime, 260, 75, 90, "/18.png"),
	CodruJi (Categories.Slime, 270, 70, 90, "/19.png"),
	Goblin (Categories.Avenger, 600, 150, 170, "/20.png"),
	Bith (Categories.Avenger, 550, 160, 180, "/21.png"),
	Rodian (Categories.Slayer, 750, 200, 210, "/22.png"),
	Talz (Categories.Slayer, 700, 215, 225, "/23.png"),
	Yarkora (Categories.Karim, 800, 80, 90, "/24.png"),
	Cerean (Categories.Karim, 770, 90, 100, "/25.png");
	
	private final Categories category;
	private final int hpMax;
	private final int attackMin;
	private final int attackMax;
	private final String imgName;

	Monsters(Categories category, int hp_max, int attack_min, int attack_max, String imgName){
		this.category = category;
		this.hpMax = hp_max;
		this.attackMin = attack_min;
		this.attackMax = attack_max;
		this.imgName = imgName;
	}
	
	public Character generateCharacterObject() {
		switch (this.category) {
		case Avenger:
			return new Avenger(this.toString(), this.category, this.hpMax, this.attackMin, this.attackMax, this.imgName);
		case Karim:
			return new Karim(this.toString(), this.category, this.hpMax, this.attackMin, this.attackMax, this.imgName);
		case Mummy:
			return new Mummy(this.toString(), this.category, this.hpMax, this.attackMin, this.attackMax, this.imgName);
		case Slayer:
			return new Slayer(this.toString(), this.category, this.hpMax, this.attackMin, this.attackMax, this.imgName);
    	case Slime:
    		return new Slime(this.toString(), this.category, this.hpMax, this.attackMin, this.attackMax, this.imgName);
    	case Spider:
    		return new Spider(this.toString(), this.category, this.hpMax, this.attackMin, this.attackMax, this.imgName);
		default:
			return new Monster(this.toString(), this.category, this.hpMax, this.attackMin, this.attackMax, this.imgName);    		
		}
	}
}
