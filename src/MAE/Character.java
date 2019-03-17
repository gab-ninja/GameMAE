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
	
	public void heal() {
	}

	public void takeDamage() {
	}

	public void attack() {
	}

};
