package MAE;


public class Human extends Player {

	public Human(Character[] characters) {
		super(characters);
		System.out.println(this.characters[0].toString());
		System.out.println(this.characters[1].toString());
		System.out.println(this.characters[2].toString());
		System.out.println(this.characters[3].toString());
		System.out.println(this.characters[4].toString());
	}

	private String name;

	public void attack() {
	}

	public void selectHeroes() {
	}
};
