package bowling;
public class Frame {
	final int num;
	int rollNumber = 0;
	int roll[] = new int[3];
	
	public Frame(int num){
		this.num = num;
	}
	
	int getNumRolls(){
		return rollNumber;
	}
	
	boolean isStrike(){
		return roll[0] == 10;
	}
	
	boolean isSpare(){
		return roll[0]+roll[1] == 10;
	}
	
	public int getFirstRoll(){
		return 0;
	}
	
	public int getSecondRoll(){
		return 0;
	}
	
	public void roll(int pins){
		roll[rollNumber++] = pins;
	}

	public int score(){
		return roll[0]+roll[1]+roll[2];
	}
}