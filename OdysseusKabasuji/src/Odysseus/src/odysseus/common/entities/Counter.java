package odysseus.common.entities;

/**
 * Keeps track of how many moves the player has made. 
 * Also keeps track of how many moves the player can make. 
 * @author Kevin Valente
 *
 */
public class Counter implements java.io.Serializable {

	private int numMoves;
	private int movesMade=0;

	public Counter(int x){
		this.numMoves = x;
	}

	/**
	 * Used to see if player has no more moves left.
	 * @return True - If the player has reached the maximum amount of moves.
	 * 
	 * @author Kevin Valente
	 */
	public boolean isOver(){
		return movesMade >= numMoves;
	}
	
	/**
	 * Updates the number of moves made by adding 1 to the current total.
	 * 
	 * @author Kevin Valente
	 */
	public void update(){
		movesMade++;
	}
	
	/**
	 * Updates the number of moves made by a certain delta.
	 * 
	 * @author Kevin Valente
	 */
	public void update(int delta){
		movesMade = movesMade + delta;
	}
	
	/**
	 * A simple getter.
	 * @return Number of moves made.
	 * 
	 * @author Kevin Valente
	 */
	public int getMovesMade(){
		return movesMade;
	}
	
	
//	public int getNumMoves(){
//		return numMoves;
//	}
	
}
