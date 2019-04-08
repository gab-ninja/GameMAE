package MAE;

abstract class Character {
	protected String name;
	protected int attackMin;
	protected int attackMax;
	protected int health;
	protected Categories category;
	protected int healthMax;
	protected boolean isMonster;
	protected int poison;
	protected String imgName;
	
	protected boolean canPlay;
	
	protected static final int POISON_DAMAGE = 20;

	public Character(String name, Categories category, int healthMax, int attackMin, int attackMax, String imgName, boolean isMonster) {
		super();
		this.name = name;
		this.category = category;
		this.healthMax = healthMax;
		this.health = healthMax;
		this.attackMin = attackMin;
		this.attackMax = attackMax;
		this.isMonster = isMonster;
		this.poison = 0;
		this.imgName = imgName;
		this.canPlay = true;
	}
	
	
	public String getName() {
		return name;
	}

	public int getHealth() {
		return health;
	}
	
	public int getMaxHealth() {
		return healthMax;
	}
	
	public int getAttackMin() {
		return this.attackMin;
	}
	
	public int getAttackMax() {
		return this.attackMax;
	}
	
	public String getImgName() {
		return this.imgName;
	}

	
	public boolean isMonster() {
		return this.isMonster;
	}
	
	public boolean isDefender() {
		return false;
	}
	
	public boolean isCleric() {
		return false;
	}
	
	public boolean isAlive() {
		return health > 0;
	}
	
	public boolean isPoisoned() {
		return this.poison > 0;
	}
	
	
	public abstract void play(GI_Battle playerInterface);
	
	public void block() {
		this.canPlay = false;
	}

	public void unBlock() {
		this.canPlay = true;
	}

	public void revive() {
		if (this.health == 0 && !this.isMonster) {
			this.health = this.healthMax / 4;
		} else {
			this.health = this.healthMax;
		}
		this.poison = 0;
	}
	
	public int heal(int heal) {
		int initialHealth = this.health;
		this.health += heal;
		if (this.healthMax < this.health) {
			this.health = this.healthMax;
		}
		return (this.health - initialHealth);
	}

	public String takeDamage(int damage, Character attacker) {
		int initialHealth = this.health;
		this.health -= damage;
		if (this.health <= 0) {
			this.health = 0;
			this.poison = 0;
		}
		return attacker.getName() + " attacked " + this.name + " for " + (initialHealth - this.health) + "HP's";
	}
	
	public void poison (int turns) {
		this.poison = this.poison + turns >= 3 ? 3 : this.poison + turns;
	}

	public String attack(Character defender, GI_Battle playerInterface) {
		if (this.isPoisoned()) {
			this.takeDamage(POISON_DAMAGE, this);
			this.poison --;
			if(!this.isAlive()) {
				return "Although " + this.getName() + " attacked " + defender.getName() + 
						", the poison was enough to kill it";
			}
		}
		int attack = this.attackMin + (int)(Math.random() * ((this.attackMax - this.attackMin) + 1));
		return defender.takeDamage(attack, this);

	}
	
	public void lowerAttack(double lower) {
		this.attackMax *= (1 - lower);
		this.attackMin *= (1 - lower);
	}
	
	@Override
	public String toString() {
		return (this.isPoisoned() ? "(P) " : " ")  + this.name + " - " + (this.isAlive() ? this.health + "/" + this.healthMax + " HP" : "FAINTED");
	}
	

};
