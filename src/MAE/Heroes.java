package MAE;

public enum Heroes {
	Iktotchi (Categories.Warrior, 700, 160, 190, "/1.png"), 
	Lasat (Categories.Warrior, 750, 150, 170, "/2.png"),
	Gotal (Categories.Paladin, 1000, 90, 100, "/3.png"),
	Nautolan (Categories.Paladin, 960, 70, 120, "/4.png"),
	Ugnaughts (Categories.Cleric, 300, 100, 120, "/5.png"),
	Jawa (Categories.Cleric, 220, 110, 150, "/6.png"),
	Duros (Categories.Assassin, 400, 200, 220, "/7.png"),
	Gungan (Categories.Assassin, 430, 190, 210, "/8.png"),
	Nikto (Categories.Rogue, 280, 150, 165, "/9.png"),
	Selonian (Categories.Berserker, 380, 150, 170, "/10.png"),
	Falleen (Categories.Monk, 250, 200, 230, "/11.png"),
	Ewok (Categories.Duelist, 500, 160, 175, "/12.png"),
	Ortolan (Categories.Defender, 600, 120, 140, "/13.png");

	private final Categories category;
	private final int hpMax;
	private final int attackMin;
	private final int attackMax;
	private final String imgName;

	Heroes(Categories category, int hp_max, int attack_min, int attack_max, String imgName){
		this.category = category;
		this.hpMax = hp_max;
		this.attackMin = attack_min;
		this.attackMax = attack_max;
		this.imgName = imgName;
	}
	
	public int getMaxAttack() {
		return this.attackMax;
	}
	
	public int getMinAttack() {
		return this.attackMin;
	}
	
	public Character generateCharacterObject() {
		switch (this.category) {
		case Warrior:
		case Paladin:
		case Assassin:
			return new BasicHero(this.toString(), this.category, this.hpMax, this.attackMin, this.attackMax, this.imgName);
		case Cleric:
			return new Cleric(this.toString(), this.category, this.hpMax, this.attackMin, this.attackMax, this.imgName);
		case Berserker:
			return new Berserker(this.toString(), this.category, this.hpMax, this.attackMin, this.attackMax, this.imgName);
		case Defender:
			return new Defender(this.toString(), this.category, this.hpMax, this.attackMin, this.attackMax, this.imgName);
		case Duelist:
			return new Duelist(this.toString(), this.category, this.hpMax, this.attackMin, this.attackMax, this.imgName);
		case Monk:
			return new Monk(this.toString(), this.category, this.hpMax, this.attackMin, this.attackMax, this.imgName);
		case Rogue:
			return new Rogue(this.toString(), this.category, this.hpMax, this.attackMin, this.attackMax, this.imgName);
		default:
			return new Hero(this.toString(), this.category, this.hpMax, this.attackMin, this.attackMax, this.imgName);
			
		}
	}
}

