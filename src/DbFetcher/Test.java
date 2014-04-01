package DbFetcher;

import java.util.Scanner;
import PokemonObj.Pokemon;

public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter pokemon name:");
		String name = scanner.next();
		Pokemon chosenpokemon = new Pokemon(name);
		chosenpokemon.populateLearnableSet();
		//chosenpokemon.printLearnableSet();
	}
}
