package MAE;


class Character {
	protected String name;
	protected int attackMin;
	protected int attackMax;
	protected int health;
	protected categories category;
	protected int healthMax;

	public Character(String name, categories category, int healthMax, int attackMin, int attackMax) {
		super();
		this.name = name;
		this.category = category;
		this.healthMax = healthMax;
		this.health = healthMax;
		this.attackMin = attackMin;
		this.attackMax = attackMax;
	}
	
	public String getName() {
		return name;
	}

	public int getHealth() {
		return health;
	}

	public void heal() {
		if (this.health == 0) {
			this.health = this.healthMax / 4;
		} else {
			this.health = this.healthMax;
		}
	}

	public void takeDamage(int damage) {
		if (this.health <0) {
			this.health += damage;
			if (this.health > 0) {
				this.health = 0;
			}
		} else {
			this.health -= damage;
			if (this.health < 0) {
				this.health = 0;
			}
		}
	}

	public void attack(Character defender) {
		if (this.health > 0) {
			int attack = this.attackMin + (int)(Math.random() * ((this.attackMax - this.attackMin) + 1));
			defender.takeDamage(attack);
		}
	}

	@Override
	public String toString() {
		return name + " (" + category + ")\t" + health + "/" + healthMax + " HP";
	}
	
	public String stats() {
		return name + " (" + category + ")\t" + healthMax + "\t" + attackMin + "/" + attackMax;
	}
	

};
