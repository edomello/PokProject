package pkmnTypes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.SortedSet;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;


public enum Type { normal(0), fire(1), water(2), electric(3), grass(4), ice(5), fighting(6), poison(7), ground(8), flying(9), psychic(10), bug(11), rock(12), ghost(13), dragon(14), dark(15), steel(16), fairy(17);

	private int typeIndex;
	private Map<Integer,Integer> nOfEffectiveness;
	
	private Type(int index){
		this.typeIndex = index;
		this.nOfEffectiveness = fetchNumberOfEffectiveness();
	}
	
	
	public int getIndex() {
		return typeIndex;
	}	
	
	
	
	private static Type getType(int index){ 
		Type[] typeList= values();
		return typeList[index]; }
	
	public Collection<Type> getWeakness(){
		float[] effectiveness = Compatibility.getCol(this.getIndex());
		Collection<Type> weaknessList = new ArrayList<Type>();
		for (int i = 0; i< effectiveness.length; i++) {
			if(effectiveness[i]>1){	weaknessList.add(getType(i)); }
		}
		return weaknessList;		
	}
	public Collection<Type> getResistance(){
		float[] effectiveness = Compatibility.getCol(this.getIndex());
		Collection<Type> resistanceList = new ArrayList<Type>();
		for (int i = 0; i< effectiveness.length; i++) {
			if(effectiveness[i]<1){	resistanceList.add(getType(i)); }
		}
		return resistanceList;		
	}
	public Collection<Type> getSuperEffectiveness(){
		float[] effectiveness = Compatibility.getRow(this.getIndex());
		Collection<Type> effectivenessList = new ArrayList<Type>();
		for (int i = 0; i< effectiveness.length; i++) {
			if(effectiveness[i]>1){	effectivenessList.add(getType(i)); }
		}
		return effectivenessList;
		}
		public Collection<Type> getLowEffectiveness(){
			float[] effectiveness = Compatibility.getRow(this.getIndex());
			Collection<Type> effectivenessList = new ArrayList<Type>();
			for (int i = 0; i< effectiveness.length; i++) {
				if(effectiveness[i]<1){	effectivenessList.add(getType(i)); }
			}
			return effectivenessList;
			};	
	
	public float getMultiplier(Type Other) {
		return Compatibility.getMultiplier(this.typeIndex, Other.typeIndex);
	}
	/**
	 * 
	 * @return hashmap: 0: low or no effective, 1: normal effective, 2: superEffective
	 */
	private Map<Integer,Integer> fetchNumberOfEffectiveness(){
		HashMap<Integer, Integer> effectList = new HashMap<Integer,Integer>();
		int numberOfLow = this.getLowEffectiveness().size();
		int numberOfSuper = this.getSuperEffectiveness().size();
		int numberOfNorm = Type.values().length - (numberOfLow + numberOfSuper) ;
		effectList.put(0, numberOfLow);
		effectList.put(1, numberOfNorm);
		effectList.put(2, numberOfSuper);
		return effectList;
	}
	
	
	
	public Map<Integer, Integer> getnOfEffectiveness() {
		return nOfEffectiveness;
	}
	 /**
	  * Compares superEffectiveness (most is better), then normal effectiveness (most is better), then low effectiveness (less is better)
	  * @param other type to compare
	  * @return +1 if this > other, 0 if equal, -1 otherwise.
	  */
	public static Comparator<Type> compareByOffence(){
		
		return new Comparator<Type>() {

			@Override
			public int compare(Type o1, Type o2) {
				if (o1.nOfEffectiveness.get(2) > o2.nOfEffectiveness.get(2)) return 1;
				if (o1.nOfEffectiveness.get(2) < o2.nOfEffectiveness.get(2)) return -1;
				//they have same number of supereffectiveness
				if (o1.nOfEffectiveness.get(1) > o2.nOfEffectiveness.get(1)) return 1;
				if (o1.nOfEffectiveness.get(1) < o2.nOfEffectiveness.get(1)) return -1;
				
				if (o1.nOfEffectiveness.get(0) > o2.nOfEffectiveness.get(0)) return -1;
				if (o1.nOfEffectiveness.get(0) < o2.nOfEffectiveness.get(0)) return 1;
				return 0;
			}
		};
		
	}

	private static Type[] orderByOffence(Type[] typeList){
		// Java's PriorityQueue class functions as a min heap
	    PriorityQueue<Type> heap = new PriorityQueue<Type>(Type.values().length,Type.compareByOffence());
	    // Add each array element to the heap
	    for (Type currentType : typeList)
	        heap.add(currentType);
	    // Elements come off the heap in ascending order
	    for (int i=0; i<typeList.length; i++)
	        typeList[i] = heap.remove();
		return typeList;
	}
	public static List<Type> getSortedByOffence(){
		Type[] resultArray = orderByOffence(Type.values());
		List<Type> resultList = new ArrayList<Type>();
		for (Type currentType : resultArray) {
			resultList.add(currentType);
		}
		return resultList;
	}
}
