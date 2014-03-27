package pkmnTypes;

import java.util.ArrayList;
import java.util.Collection;


public enum Type { normal(0), fire(1), water(2), electric(3), grass(4), ice(5), fighting(6), poison(7), ground(8), flying(9), psychic(10), bug(11), rock(12), ghost(13), dragon(14), dark(15), steel(16), fairy(17);

	private int typeIndex;
	private Type(int index){
		this.typeIndex = index;
	}
	
	
	public int getIndex(){return typeIndex;}
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
		};
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
}
