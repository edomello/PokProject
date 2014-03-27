package pkmnTypes;
import java.io.InputStream;
import java.util.Collection;
import java.util.Scanner;
import pkmnTypes.Type;

public class UserInterface {
	private final Scanner scanner;
	public UserInterface(InputStream input) {
		this.scanner=new Scanner(input);
	}

	public void weakResRequest() {
		System.out.println("Insert a Type:");
		String input = scanner.next();
		Type choice = null;
		try{
		choice = Enum.valueOf(Type.class, input);
		Collection<Type> weaknesses = choice.getWeakness();
		Collection<Type> resinstances = choice.getResistance();
		if (!weaknesses.isEmpty()) {
			System.out.println(choice.toString() + " has the following weaknesses:");
			for (Type type : weaknesses) {
				System.out.println(type.toString() + "(" + type.getMultiplier(choice) + "x)");
			}
		}
		if (!resinstances.isEmpty()) {
			System.out.println(choice.toString() + " has the following resinstances:");
			for (Type type : resinstances) {
				System.out.println(type.toString() + "(" + type.getMultiplier(choice) + "x)");
			}
		}
		}
		catch(IllegalArgumentException e) { System.out.println("Wrong Type name!");  }
		
	}
	
	public void compatibilityRequest() {
		try{
		System.out.println("Insert Attacker:");
		String input = scanner.next();
		Type choice1 = Enum.valueOf(Type.class, input);
		System.out.println("Insert Defender:");
		input = scanner.next();
		Type choice2 = Enum.valueOf(Type.class, input);
		float multiplier = Compatibility.getMultiplier(choice1.getIndex(), choice2.getIndex());
		if (multiplier>1) {
			System.out.println(choice1.toString() + " is very effective against " + choice2.toString() + " ("+ multiplier + ")");
		}
		if (multiplier<1) {
			System.out.println(choice1.toString() + " is not very effective against " + choice2.toString() + " ("+ multiplier + ")");
		}
		if (multiplier==1) {
			System.out.println(choice1.toString() + " does normal damage to " + choice2.toString() + " ("+ multiplier + ")");
		}
		}
		catch(IllegalArgumentException e) { System.out.println("Wrong Type name!");  }
		
	}
	
	public void printTable(){
		Type[] listatipi = Type.values();
		StringBuffer introw = new StringBuffer("     "); 
		for (Type intest : listatipi) {
			introw.append(intest.toString().substring(0, 3).toUpperCase() + "  ");
		}
		System.out.println(introw);
		for (Type type1 : listatipi){
			StringBuffer tabrow = new StringBuffer(); 
			tabrow.append(type1.toString().substring(0, 3).toUpperCase() + "  ");
			for (Type type2 : listatipi) {
				tabrow.append(Compatibility.getMultiplier(type1.getIndex(), type2.getIndex()) + "  ");
			}
			System.out.println(tabrow);
		}
		
		
	}


}
