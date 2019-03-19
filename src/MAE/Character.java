package MAE;


class Character {
	protected String name;
	protected int attackMin;
	protected int attackMax;
	protected int health;
	protected categories category;
	protected int healthMax;
	protected boolean canPlay;
	protected boolean isMonster;

	public Character(String name, categories category, int healthMax, int attackMin, int attackMax, boolean isMonster) {
		super();
		this.name = name;
		this.category = category;
		this.healthMax = healthMax;
		this.health = healthMax;
		this.attackMin = attackMin;
		this.attackMax = attackMax;
		this.canPlay = true;
		this.isMonster = isMonster;
	}
	
	public String getName() {
		return name;
	}

	public int getHealth() {
		return health;
	}
	
	public int getAttackMin() {
		return this.attackMin;
	}
	
	public boolean isAlive() {
		return health > 0;
	}
	
	public boolean isMonster() {
		return this.isMonster;
	}
	
	public boolean isCleric() {
		return this.attackMin < 0;
	}
	
	public boolean canPlay() {
		return this.canPlay && this.health > 0;
	}
	
	public void block() {
		this.canPlay = false;
	}

	public void unBlock() {
		this.canPlay = true;
	}

	public void heal() {
		if (this.health == 0) {
			this.health = this.healthMax / 4;
		} else {
			this.health = this.healthMax;
		}
	}

	public void takeDamage(int damage) {
		this.health -= damage;
		if (this.health < 0) {
			this.health = 0;
		}
		if (this.health > this.healthMax) {
			this.health = this.healthMax;
		}
	}

	public int attack(Character defender) {
		int attack = this.attackMin + (int)(Math.random() * ((this.attackMax - this.attackMin) + 1));
		defender.takeDamage(attack);
		return attack;
	}

	@Override
	public String toString() {
		if (this.category.toString().length() +  this.name.length() < 10) {
			return name + " (" + this.category + ") \t\t" + this.health + "/" + this.healthMax + " HP";
		}
		return name + " (" + this.category + ") \t" + this.health + "/" + this.healthMax + " HP";
	}
	
	public String stats() {
		if (this.category.toString().length() +  this.name.length() < 18) {
			return name + " (" + this.category + ")\t\t" + this.healthMax + "\t" + this.attackMin + "/" + this.attackMax;
		}
		return name + " (" + this.category + ")\t" + this.healthMax + "\t" + this.attackMin + "/" + this.attackMax;
	}
	

};
