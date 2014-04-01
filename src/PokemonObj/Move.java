package PokemonObj;

import pkmnTypes.Type;

public class Move {
	private int id;
	private String name;
	private int power;
	private Type type;
	private int dmgType;
	private int TMNumber;
	public Move() {
		// TODO Auto-generated constructor stub
	}
	
	public Move(int id, String name, int power, String typeName, int dmgType, int TMNumber) {
		this.id =id;
		this.name = name;
		this.power = power;
		this.type = Type.valueOf(typeName);
		this.dmgType = dmgType;
		this.TMNumber = TMNumber;
	}
	
	public int getId(){return this.id;}
	public String getName(){return this.name;}
	public int getPower(){return this.power;}
	public Type getType(){return this.type;}
	public int getDmgType(){return this.dmgType;}
	public int getTMNumber(){return this.TMNumber;}
	}
	
	

