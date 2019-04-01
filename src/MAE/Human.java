package MAE;

import java.util.*;

public class Human extends Player {
	private String name;
	
	public Human(ArrayList<Character> characters, String name, GI_Battle playerInterface) {
		super(playerInterface);
		this.setTeam(characters);
		this.name = name;
		this.playerInterface = playerInterface;
		this.playerInterface.loadHeroes(this.team);
		
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
