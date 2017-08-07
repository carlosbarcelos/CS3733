package odysseus.common.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

/**
 * Lightning is a subclass of Level, there is only a fixed amount of time for moves to be made.
 * 
 * @author Carlos Barcelos
 *
 */

public class Lightning extends AbsLevel {
		
	public final long TIME_LIMIT;
	GameTimer gt;

	public Lightning(Board board, Bullpen bullpen, int levelNumber, boolean isUnlocked, List<Piece> pieces, Long timeLimit){
		super(board,bullpen,"Lightning",levelNumber,isUnlocked,pieces);

		this.TIME_LIMIT = timeLimit;
		gt = new GameTimer(TIME_LIMIT);
	}


	

	/**
	 * Lightning is over when time limit is met.
	 * @return isOver - Returns whether timePlayed > timeLimit
	 * 
	 * @author Carlos Barcelos
	 */
	@Override
	public boolean isOver(){
		return gt.isOver();
	}

	/**
	 * Returns the number of stars earned for the level. 
	 * Stars are earned by covering squares.
	 * 
	 * @return starsEarned - The number of stars that the player has received for the level.
	 * 
	 * @author Carlos Barcelos
	 */
	@Override
	public int starsEarned(){
		int starsEarned = 0;
		int squaresRemaining = board.numSquares() - board.numFilledSquares();

		if(squaresRemaining == 0){
			starsEarned = 3;
		} else if(squaresRemaining == 6){
			starsEarned = 2;
		} else if(squaresRemaining == 12){
			starsEarned = 1;
		} 

		return starsEarned;
	}


}
