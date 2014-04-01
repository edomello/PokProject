package PokemonObj;

import java.util.ArrayList;

import DbFetcher.PokedexConnection;
import pkmnTypes.Type;

public class Pokemon {
	private int id;
	private String name;
	private Type type1;
	private	Type type2;
	private ArrayList<MoveLearn> learnableSet;
	private	CombatStyle role;
	
	
	public Pokemon() {
		this.id=0;
		name="MissingNo";
		type1 = null;
		type2=null;
	}
	
	public Pokemon(String pokemonName){
		this.name = pokemonName;
		learnableSet = new ArrayList<MoveLearn>();
		PokedexConnection pokemonFetcher = new PokedexConnection();
		pokemonFetcher.getPokemonDataFromName(this);
	}
	
	public Pokemon(int id, String name, Type type1, Type type2, CombatStyle role) {
		this.id = id;
		this.name = name;
		this.type1 = type1;
		this.type2 = type2;
		learnableSet = new ArrayList<MoveLearn>();
		this.role = role;
	}
	public void setId(int id){this.id = id;}
	public int getId(){return this.id;}
	public void setName(String name){this.name = name;}
	public String getName(){return this.name;}
	public void setType1(Type type1){this.type1=type1;}
	public Type getType1(){return this.type1;}
	public void setType2(Type type2){this.type2=type2;}
	public Type getType2(){return this.type2;}
	public void setRole(CombatStyle role){this.role = role;}
	public CombatStyle getRole() {return this.role;	}
	
	
	public ArrayList<MoveLearn> getLearnableSet(){return learnableSet;};
	public void printLearnableSet(){
		System.out.println(this.name + " can learn the following moves: ");
		for (MoveLearn currentMove : this.learnableSet) {
			System.out.println(currentMove.getMove().getName() + ", power: "+ Integer.toString(currentMove.getMove().getPower()) + ", at level: " + Integer.toString(currentMove.getLevel()) +" or TM" + Integer.toString(currentMove.getMove().getTMNumber()));
		}
		
		
		
	}
	public void populateLearnableSet() {
		PokedexConnection setPopulator = new PokedexConnection();
		System.out.println("Popolo il set");
		setPopulator.getLearnSet(this.id, this.learnableSet);
		
	}
	
	
	
	
	
}
