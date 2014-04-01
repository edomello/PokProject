package PokemonObj;

public enum CombatStyle {
	PhysicalAttacker(0),SpecialAttacker(1),Mixed(2),Tank(3),Utility(4);
	int index;
	private CombatStyle(int index) {
		this.index = index;
	}
}
