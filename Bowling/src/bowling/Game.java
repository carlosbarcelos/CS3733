package bowling;
public class Game {
	Frame[] frames = new Frame[10];
	int currentFrame = 0;
	
	final static int MAXFRAME = 10;
	
	public Game(){
		for(int i = 0; i < MAXFRAME; i++){
			frames[i] = new Frame(i+1);
		}
	}
	
	public void roll(int pins){
		frames[currentFrame].roll(pins);
		if(pins == 10){
			//advance frame
		} else if(frames[currentFrame].getNumRolls() == 2){
			//advance frame
		}
	}
	
	public int score(){
		int score = 0;
		for(int i = 0; i <= currentFrame; i++){
			Frame f = frames[i];
			if(!f.isSpare() && !f.isStrike()){
				score += f.score();
			} else if(f.isSpare()){
				score += 10 + frames[i+1].getFirstRoll();
			} else if(f.isStrike()){
				score += 10 + frames[i+1].getSecondRoll();
			}
		}
		
		return score;
	}
	
}
