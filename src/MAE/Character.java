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
	
	private static final int POISON_DAMAGE = 20;

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
	
	public int getAttackMin() {
		return this.attackMin;
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
	
	public void heal(int heal) {
		this.health += heal;
		if (this.healthMax < this.health) {
			this.health = this.healthMax;
		}
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
			this.takeDamage(POISON_DAMAGE, this);
			this.poison --;
			if(!this.isAlive()) {
				return res;
			}
		}
		int attack = this.attackMin + (int)(Math.random() * ((this.attackMax - this.attackMin) + 1));
		if(defender.takeDamage(attack, this)) {
			res[0] = attack;
		}else{
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
