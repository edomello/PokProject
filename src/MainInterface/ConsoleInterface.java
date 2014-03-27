package MainInterface;


import java.io.InputStream;
import java.util.Scanner;

import pkmnTypes.*;

public class ConsoleInterface {
	private final Scanner scanner;
	public ConsoleInterface(InputStream input) {
		this.scanner=new Scanner(input);
	}
	
	public static void main(String[] args) {
		ConsoleInterface consoleInterface = new ConsoleInterface(System.in);
		
		
		consoleInterface.menu();
    	
    
	}
	
	
	private void menu() {
		do{
		System.out.println("Select a function. Type 'exit' to quit.");
		System.out.println("0: Print Compatibility table");
		System.out.println("1: Weakness and Resistance check");
		System.out.println("2: Attack Compatibility check");
		System.out.println("3: Moveset Coverage");
		String menuchoice = scanner.next();
		pkmnTypes.UserInterface typesUI = new UserInterface(System.in);
		
		switch (menuchoice) {
		case "exit": return;
		case "0":
			typesUI.printTable();
			break;
		case "1":
			typesUI.weakResRequest();
			break;
		case "2":
			typesUI.compatibilityRequest();
			break;
		case "3":
			Coverage.UserInterface coverageUI = new Coverage.UserInterface(System.in);
			coverageUI.moveCoverageRequest();
			break;
		default:
			System.out.println("Selection not valid.");
			break;
		}}
			while (true);
		
	}
}
