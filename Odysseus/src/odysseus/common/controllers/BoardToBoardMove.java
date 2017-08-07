package odysseus.common.controllers;
import odysseus.Builder;
import odysseus.Kabasuji;
import odysseus.common.entities.*;

/**
 * The BoardToBoardMove moves a piece from one valid location on the board to another.
 * 
 * A piece must not go beyond the bounds of a board and must fit within the playable squares
 * without crossing into the non-playable squares.
 * 
 * @author Carlos Barcelos
 *
 */
public class BoardToBoardMove extends Move {

	Board board;
	Piece target;
	Piece source;
	Counter c;

	public BoardToBoardMove(Board board, Piece source, Piece target,Counter c){
		this.board = board;
		this.target = target;
		this.source = source;
		this.c = c;
	}

	/**
	 * If the move is valid remove it from its original location in the board and place it 
	 * in the new location.
	 * 
	 * @return False -if the move is invalid. Otherwise returns true.
	 */
	@Override
	public boolean doMove(Kabasuji game){
		if(!valid(game)){return false;}

		board.remove(source);
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
		
		board.remove(target);
		board.add(source);
		
		// Try to update the counter, if not puzzle, do nothing
		try{
			c.update(-1);
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
	public boolean valid(Kabasuji game){

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
