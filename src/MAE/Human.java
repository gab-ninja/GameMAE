package MAE;
import java.util.*;

public class Human extends Player {
	private String name;
	
	public Human(ArrayList<Character> characters) {
		super(characters);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void attack() {
	}

	public void selectHeroes() {
	}
};
