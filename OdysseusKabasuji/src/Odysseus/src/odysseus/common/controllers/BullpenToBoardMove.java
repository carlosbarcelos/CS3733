package odysseus.common.controllers;
import odysseus.Kabasuji;
import odysseus.common.entities.*;

/**
 * The BullpenToBoardMove moves a piece from the level's bullpen to the level's board.
 * 
 * In order for this piece to be valid, the squares of the piece must be allowed to fit onto the board.
 * It may not overlap with squares already in play or go beyond the limits of the board
 * 
 * @author Carlos Barcelos
 *
 */
public class BullpenToBoardMove extends Move {

	Bullpen bullpen;
	Board board;
	Piece target;
	Counter c;

	public BullpenToBoardMove(Bullpen bullpen, Board board, Piece target, Counter c){
		this.bullpen = bullpen;
		this.board = board;
		this.target = target;
		this.c = c;
	}

	/**
	 * If the move is valid remove it from its original location in the board and place it 
	 * in the new location.
	 * 
	 * @return False -if the move is invalid. Otherwise returns true.
	 */
	@Override
	public boolean doMove(Kabasuji game) {
		// Can the move be done
		if(!valid(game)){return false;}


		// Do the move
		Piece p = bullpen.remove(target);
		board.add(target);


		// Try to update the counter, if not puzzle, do nothing
		try{
			c.update();
		} catch(NullPointerException n){}
		return true;
	}

	/**
	 * Undoes any previous Board to Board Moves.
	 * 
	 * @return True- if move was successfully undo. 
	 */
	@Override
	public boolean undo(Kabasuji game) {
		if(bullpen.empty()){return false;}

		// Do the move

		bullpen.add(board.remove(target));

		// An undo will count as a move
		try{
			c.update();
		} catch(NullPointerException n){}
		return true;
	}

	/**
	 * Iterates through the piece's squares to the corresponding board
	 * to check if any piece-squares are moving to invalid board-squares.
	 * 
	 * @return False - If any squares overlap which should not. Otherwise returns true.
	 */
	@Override
	public boolean valid(Kabasuji game) {
		// No piece to play
		if(bullpen.empty()){return false;}

		// Now onto the squares
		boolean validation = false;
		Square s;
		// Check that each square is valid
		for(int i : target.getLocation()){
			s = target.decodeSquare(i);
			validation = board.isPlayableSquare(s);
		}
		return validation;
	}
}
