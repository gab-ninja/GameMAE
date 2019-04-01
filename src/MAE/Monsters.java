package MAE;

public enum Monsters {
	Hutt (Categories.Spider, 250, 80, 100),
	Darth (Categories.Spider, 280, 70, 90),
	Miraluka (Categories.Mummy, 500, 210, 230),
	Mirialan (Categories.Mummy, 490, 215, 230),
	Kaleesh (Categories.Slime, 260, 75, 90),
	CodruJi (Categories.Slime, 270, 70, 90),
	Goblin (Categories.Avenger, 600, 150, 170),
	Bith (Categories.Avenger, 550, 160, 180),
	Rodian (Categories.Slayer, 750, 200, 210),
	Talz (Categories.Slayer, 700, 215, 225),
	Yarkora (Categories.Karim, 800, 30, 50),
	Cerean (Categories.Karim, 770, 40, 70);
	
	private final Categories category;
	private final int hpMax;
	private final int attackMin;
	private final int attackMax;

	Monsters(Categories category, int hp_max, int attack_min, int attack_max){
		this.category = category;
		this.hpMax = hp_max;
		this.attackMin = attack_min;
		this.attackMax = attack_max;
	}
	
	public Character generateCharacterObject() {
		switch (this.category) {
		case Avenger:
			return new Avenger(this.toString(), this.category, this.hpMax, this.attackMin, this.attackMax);
		case Karim:
			return new Karim(this.toString(), this.category, this.hpMax, this.attackMin, this.attackMax);
		case Mummy:
			return new Mummy(this.toString(), this.category, this.hpMax, this.attackMin, this.attackMax);
		case Slayer:
			return new Slayer(this.toString(), this.category, this.hpMax, this.attackMin, this.attackMax);
    	case Slime:
    		return new Slime(this.toString(), this.category, this.hpMax, this.attackMin, this.attackMax);
    	case Spider:
    		return new Rogue(this.toString(), this.category, this.hpMax, this.attackMin, this.attackMax);
		default:
			return new Character(this.toString(), this.category, this.hpMax, this.attackMin, this.attackMax, true);    		
		}
	}
}
