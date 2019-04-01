package MAE;

class Character {
	protected String name;
	protected int attackMin;
	protected int attackMax;
	protected int health;
	protected Categories category;
	protected int healthMax;
	protected boolean canPlay;
	protected boolean isMonster;
	protected int poison;

	public Character(String name, Categories category, int healthMax, int attackMin, int attackMax, boolean isMonster) {
		super();
		this.name = name;
		this.category = category;
		this.healthMax = healthMax;
		this.health = healthMax;
		this.attackMin = attackMin;
		this.attackMax = attackMax;
		this.canPlay = true;
		this.isMonster = isMonster;
		this.poison = 0;
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
	
	public boolean isDuelist() {
		if (this.category == Categories.Duelist) {
			return true;
		}
		return false;
	}
	
	public boolean isDefender() {
		if (this.category == Categories.Defender) {
			return true;
		}
		return false;
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
	
	public boolean isPoisoned() {
		return this.poison > 0;
	}
	
	public void play() {
		if (this.canPlay && this.health > 0) {
			return;
		}
		return;
	}
	
	public void block() {
		this.canPlay = false;
	}

	public void unBlock() {
		this.canPlay = true;
	}

	public void heal() {
		if (this.health == 0 && !this.isMonster) {
			this.health = this.healthMax / 4;
		} else {
			this.health = this.healthMax;
		}
		this.poison = 0;
	}

	public boolean takeDamage(int damage, Character attacker) {
		this.health -= damage;
		if (this.health <= 0) {
			this.health = 0;
			this.poison = 0;
		}
		if (this.health > this.healthMax) {
			this.health = this.healthMax;
		}
		return true;
	}
	
	public void poison (int turns) {
		this.poison = this.poison + turns >= 3 ? 3 : this.poison + turns;
	}

	public int[] attack(Character defender) {
		int[] res = {0,0};
		if (this.isPoisoned()) {
			this.takeDamage(20, this);
			this.poison --;
			if(!this.isAlive()) {
				return res;
			}
		}
		int attack = this.attackMin + (int)(Math.random() * ((this.attackMax - this.attackMin) + 1));
		if(defender.takeDamage(attack, this)) {
			res[0] = attack;	
			if (defender.isDefender() && attack > 0) {
				int health = this.getHealth();
				if (defender.isAlive()) {
					defender.attack(this);
				}
				res[1] = health - this.getHealth();
			}
		} else {
			res[0] = -1;
		}
		return res;
	}

	@Override
	public String toString() {
		if (this.category.toString().length() +  this.name.length() < 10) {
			return name + (this.isPoisoned() ? "*(" : " (") + this.category + ") \t\t" + this.health + "/" + this.healthMax + " HP";
		}
		return name + (this.isPoisoned() ? "*(" : " (")  + this.category + ") \t" + this.health + "/" + this.healthMax + " HP";
	}
	
	public String stats() {
		if (this.category.toString().length() +  this.name.length() < 18) {
			return name + " (" + this.category + ")\t\t" + this.healthMax + "\t" + this.attackMin + "/" + this.attackMax;
		}
		return name + " (" + this.category + ")\t" + this.healthMax + "\t" + this.attackMin + "/" + this.attackMax;
	}
	

};
