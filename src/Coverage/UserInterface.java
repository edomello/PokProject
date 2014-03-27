package Coverage;
import java.io.InputStream;
import java.util.Collection;
import java.util.Scanner;

import org.omg.CORBA.PUBLIC_MEMBER;

import pkmnTypes.Type;

public class UserInterface {
	private final Scanner scanner;
	public UserInterface(InputStream input) {
		this.scanner=new Scanner(input);
	}
	
	
	public void moveCoverageRequest () throws IllegalArgumentException { 
		Type move1, move2, move3, move4; 
		System.out.println("Insert type of move 1:");
		move1 = Enum.valueOf(Type.class, scanner.next());
		System.out.println("Insert type of move 2:");
	 move2 = Enum.valueOf(Type.class, scanner.next());
		System.out.println("Insert type of move 3:");
		move3 = Enum.valueOf(Type.class, scanner.next());
		System.out.println("Insert type of move 4:");
		move4 = Enum.valueOf(Type.class, scanner.next());

		Collection<Type> coverageList = MoveCoverage.getMoveCoverage(move1, move2, move3, move4);
		System.out.print("Your MoveSet currently covers the following types: ");
		for (Type covered : coverageList) {
			System.out.println(covered.toString());
		}
		
		
		
		}
	
	
	}