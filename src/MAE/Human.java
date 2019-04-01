package MAE;

import java.util.*;

import MAE.Character;

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
	
	public ArrayList<Character> getCharactersToAttack(){
		ArrayList <Character> charactersToAttack = new ArrayList<Character>();
		charactersToAttack = this.getCharactersAlive();
		int listSize = charactersToAttack.size();
		for (int i=0; i < listSize; i++) {
			if (charactersToAttack.get(i).isDefender()) {
				charactersToAttack.add(i, charactersToAttack.get(i));
				i++;
				listSize ++;
			}
		}
		return charactersToAttack;
	}

	public void attack() {
	}

	public void selectHeroes() {
	}
};
