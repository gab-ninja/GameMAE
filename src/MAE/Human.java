package MAE;

import java.util.*;

import MAE.Character;

public class Human extends Player {
	private String name;
	private ArrayList<Item> items = new ArrayList<Item>();
	private int budget;
	
	public Human(ArrayList<Character> characters, String name) {
		super();
		this.setTeam(characters);
		this.name = name;
		this.budget = 0;
	}
	
	@Override
	public void setInterface(GI_Battle playerInterface) {
		super.setInterface(playerInterface);
		this.playerInterface.setHuman(this);
		this.playerInterface.loadHeroes(this.team);
	}
	
	public int getBudget() {
		return this.budget;
	}
	
	public void addCoins(int coins) {
		this.budget+= coins;
	}
	
	public void takeCoins(int coins) {
		this.budget-= coins;
	}
	
	public void updateHeroes() {
		this.playerInterface.loadHeroes(this.team);
	}

	public String getName() {
		return name;
	}
	
	public boolean hasItems() {
		return !this.items.isEmpty();
	}
	
	public ArrayList<Item> addItems(Item item) {
		this.items.add(item);
		return this.items;
	}
	
	public ArrayList<Item> getItems() {
		return this.items;
	}
	
	public void removeItem(Item item) {
		this.items.remove(item);
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
};
