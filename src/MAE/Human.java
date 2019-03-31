package MAE;
import java.util.*;

public class Human extends Player {
	private String name;
	
	public Human(ArrayList<Character> characters, String name) {
		super(characters);
		this.name = name;
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
