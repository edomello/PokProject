package PokemonObj;


public class MoveLearn {
 private Move move;
 private int level;
 private int methodId;
 
 public void setMove(Move move){this.move = move;}
 public Move getMove(){return this.move;}
 public void setLevel(int level){this.level = level;}
 public int getLevel(){return this.level;}
 public void setMethod(int methodId){this.methodId = methodId;}
 public int getMethod(){return this.methodId;}
 
 public MoveLearn(Move move, int level, int methodId) {
	 this.move = move;
	 this.level = level;
	 this.methodId = methodId;
 }
 
 
}
