package odysseus.common.entities;

import java.util.*;

/**
 * Puzzle is a subclass of Level, win by removing at least all but two pieces
 * from the bullpen before the move limit is reached.
 * 
 * @author Carlos Barcelos
 *
 */
public class Puzzle extends AbsLevel {
	public Counter counter;
	//public BullpenView bullpenView;

	public Puzzle(Board board, Bullpen bullpen, int levelNumber, boolean isUnlocked, List<Piece> pieces, int extraMoves){
		super(board,bullpen,"Puzzle",levelNumber,isUnlocked,pieces);
		try{
			this.counter = new Counter(pieces.size() + extraMoves); // There are at least as many moves as there are pieces
		} catch(NullPointerException n){
			this.counter = new Counter(extraMoves);
			System.err.println("Puzzle :: constructor - No pieces to call piece size, call 0.");
		}
	}
	
//	public void initializeControllers(){
//		bullpenView.addMouseListener(new PieceSelectionController(bullpenView, new Model(this)));
//	}


	/**
	 * Returns the number of stars earned for the level.
	 * Stars are earned by removing pieces from the bullpen.
	 * 
	 * @return starsEarned - The number of stars that the player has received for the level.
	 * 
	 * @author Kevin Valente
	 */
	@Override
	public int starsEarned(){
		int starsEarned = 0;
		int piecesRemaining = bullpen.getNumberPieces();

		if(piecesRemaining == 0){
			starsEarned = 3;
		} else if(piecesRemaining == 1){
			starsEarned = 2;
		} else if(piecesRemaining == 2){
			starsEarned = 1;
		} 

		return starsEarned;
	}	


	/**
	 * Puzzle is over when move limit is reached.
	 * @return isOver - Returns whether movedMade > movesAllowed.
	 * 
	 * @author Carlos Barcelos
	 */
	@Override
	public boolean isOver(){
		return counter.isOver();
	}

}
