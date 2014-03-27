package Coverage;
import pkmnTypes.Type;

import java.util.ArrayList;
import java.util.Collection;

public class MoveCoverage  {

	public static Collection<Type> getMoveCoverage(Type move1, Type move2, Type move3, Type move4) throws IllegalArgumentException {
		ArrayList<Type> coverageList = new ArrayList<Type>();
		 if (move1 != null){
			 coverageList.removeAll(move1.getSuperEffectiveness());
			 coverageList.addAll(move1.getSuperEffectiveness()); 
			 if (move2 != null) {
				 coverageList.removeAll(move2.getSuperEffectiveness());
				 coverageList.addAll(move2.getSuperEffectiveness());
				if (move3 != null){
					coverageList.removeAll(move3.getSuperEffectiveness());
					coverageList.addAll(move3.getSuperEffectiveness());
					 if (move4 != null) {
						 coverageList.removeAll(move4.getSuperEffectiveness());
						 coverageList.addAll(move4.getSuperEffectiveness());
					}
				 }
			}
		 } else
		 {IllegalArgumentException e = new IllegalArgumentException("First Move cannot be empty!");
		 throw e;
		 }
		return coverageList;
	}
	
	
}
