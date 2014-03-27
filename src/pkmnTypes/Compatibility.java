package pkmnTypes;

public class Compatibility {
	public static int typesNumber = 18;
	private static float compatibilityTable[][] = new float[][] {
	{1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	(float) 0.5,	0,	1,	1,	(float) 0.5,	1	},
	{1,	(float) 0.5,	(float) 0.5,	1,	2,	2,	1,	1,	1,	1,	1,	2,	(float) 0.5,	1,	(float) 0.5,	1,	2,	1},
	{1,2,(float) 0.5,1,(float) 0.5,1,1,1,2,1,1,1,2,1,(float) 0.5,1,1,1},
	{1,1,2,(float) 0.5,(float) 0.5,1,1,1,0,2,1,1,1,1,(float) 0.5,1,1,1},
	{1,(float) 0.5,2,1,(float) 0.5,1,1,(float) 0.5,2,(float) 0.5,1,(float) 0.5,2,1,(float) 0.5,1,(float) 0.5,1},
	{1,(float) 0.5,(float) 0.5,1,2,(float) 0.5,1,1,2,2,1,1,1,1,2,1,(float) 0.5,1},
	{2,1,1,1,1,2,1,(float) 0.5,1,(float) 0.5,(float) 0.5,(float) 0.5,2,0,1,2,2,(float) 0.5,1},
	{1,1,1,1,2,1,1,(float) 0.5,(float) 0.5,1,1,1,(float) 0.5,(float) 0.5,1,1,0,2},
	{1,2,1,2,(float) 0.5,1,1,2,1,0,1,(float) 0.5,2,1,1,1,2,1},
	{1,1,1,(float) 0.5,2,1,2,1,1,1,1,2,(float) 0.5,1,1,1,(float) 0.5,1},
	{1,1,1,1,1,1,2,2,1,1,(float) 0.5,1,1,1,1,0,(float) 0.5,1},
	{1,(float) 0.5,1,1,2,1,(float) 0.5,(float) 0.5,1,(float) 0.5,2,1,1,(float) 0.5,1,2,(float) 0.5,(float) 0.5},
	{1,2,1,1,1,2,(float) 0.5,1,(float) 0.5,2,1,2,1,1,1,1,(float) 0.5,1},
	{0,1,1,1,1,1,1,1,1,1,2,1,1,2,1,(float) 0.5,1,1},
	{1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,(float) 0.5,0},
	{1,1,1,1,1,1,(float) 0.5,1,1,1,2,1,1,2,1,(float) 0.5,1,(float) 0.5},
	{1,(float) 0.5,(float) 0.5,(float) 0.5,1,2,1,1,1,1,1,1,2,1,1,1,(float) 0.5,2},
	{1,(float) 0.5,1,1,1,1,2,(float) 0.5,1,1,1,1,1,1,2,2,(float) 0.5,1}};
	
	public static float[] getRow(int index) {
		float[] row = new float[typesNumber];
		for (int i = 0; i < typesNumber; i++) {
			row[i]=compatibilityTable[index][i];
		}
		return row;
	}
	public static float[] getCol(int index) {
		float[] row = new float[typesNumber];
		for (int i = 0; i < typesNumber; i++) {
			row[i]=compatibilityTable[i][index];
			
		}
		return row;
	}
	public static float getMultiplier(int attacker, int defender) {
		return compatibilityTable[attacker][defender];
	}
	
}
