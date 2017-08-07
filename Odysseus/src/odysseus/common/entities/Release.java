package odysseus.common.entities;

import java.util.List;

/**
 * Release is a subclass of Level, win by freeing number sets.
 * 
 * @author Carlos Barcelos
 */
public class Release extends AbsLevel {
	

	public Release(Board board, Bullpen bullpen, int levelNumber, boolean isUnlocked, List<Piece> pieces){
		super(board,bullpen,"Release",levelNumber,isUnlocked,pieces);
	}
	
	
	/**
	 * Verifies how many numbers sets are covered.
	 * 
	 * @return the number of covered number sets  .
	 * 
	 * @author Justin Myerson
	 */
	public int numberSetsCovered(){
		int numSetsCovered = 0;
		boolean yellow = true;
		boolean red = true;
		boolean blue = true;
		ReleaseSquare rs;
		
		for(int i = 0; i < 18; i++){
			rs = (ReleaseSquare) board.getReleaseSquares()[i];
			if(rs.getColor() == 1){
				if(rs.isFilled() == false){
					yellow = false;
				}
			}
			
			if(rs.getColor() == 2){
				if(rs.isFilled() == false){
					red = false;
				}
			}
			
			if(rs.getColor() == 3){
				if(rs.isFilled() == false){
					blue = false;
				}
			}
		}
		
		if(yellow == true){
			numSetsCovered++;
		}
		if(red == true){
			numSetsCovered++;
		}
		if(blue == true){
			numSetsCovered++;
		}
		
		
		return numSetsCovered;
	}
	
	/**
	 * Returns the number of stars earned for the level.
	 * Stars are earned by covering number sets.
	 * 
	 * @return starsEarned - The number of stars that the player has received for the level.
	 * 
	 * @author Carlos Barcelos
	 */
	@Override
	public int starsEarned(){
		int starsEarned = 0;
		int setsReleased = numberSetsCovered();
		
		if(setsReleased == 3){
			starsEarned = 3;
		} else if(setsReleased == 2){
			starsEarned = 2;
		} else if(setsReleased == 1){
			starsEarned = 1;
		} 
		
		return starsEarned;
	}
	
	/**
	 * Release is over when there are no more pieces to be played.
	 * @return isOver - Returns whether bullpen.empty().
	 * 
	 * @author Carlos Barcelos
	 */
	@Override
	public boolean isOver(){
		return bullpen.empty();
	}

}
