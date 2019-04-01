package MAE;

public enum Heroes {
	Iktotchi (Categories.Warrior, 700, 160, 190), 
	Lasat (Categories.Warrior,750,150,170),
	Gotal (Categories.Paladin,1000,90,100),
	Nautolan (Categories.Paladin,960,70,120),
	Ugnaughts (Categories.Cleric,300,-50,-70),
	Jawa (Categories.Cleric,220,-60,-90),
	Duros (Categories.Assassin,400,200,220),
	Gungan (Categories.Assassin,430,190,210),
	Nikto (Categories.Rogue,280,150,165),
	Selonian (Categories.Berserker,380,150,170),
	Falleen (Categories.Monk,250,200,230),
	Ewok (Categories.Duelist,500,160,175),
	Ortolan (Categories.Defender,600,120,140);

	private final Categories category;
	private final int hpMax;
	private final int attackMin;
	private final int attackMax;

	Heroes(Categories category, int hp_max, int attack_min, int attack_max){
		this.category = category;
		this.hpMax = hp_max;
		this.attackMin = attack_min;
		this.attackMax = attack_max;
	}
	
	public Character generateCharacterObject() {
		switch (this.category) {
		case Warrior:
		case Paladin:
		case Assassin:
		case Cleric:
			return new BasicHero(this.toString(), this.category, this.hpMax, this.attackMin, this.attackMax);
		case Berserker:
			return new Berserker(this.toString(), this.category, this.hpMax, this.attackMin, this.attackMax);
		case Defender:
			return new Defender(this.toString(), this.category, this.hpMax, this.attackMin, this.attackMax);
		case Duelist:
			return new Duelist(this.toString(), this.category, this.hpMax, this.attackMin, this.attackMax);
		case Monk:
			return new Monk(this.toString(), this.category, this.hpMax, this.attackMin, this.attackMax);
		case Rogue:
			return new Rogue(this.toString(), this.category, this.hpMax, this.attackMin, this.attackMax);
		default:
			return new Character(this.toString(), this.category, this.hpMax, this.attackMin, this.attackMax, false);
			
		}
	}
}

