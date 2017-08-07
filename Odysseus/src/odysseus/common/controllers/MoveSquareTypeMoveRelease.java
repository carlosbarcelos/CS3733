
package odysseus.common.controllers;

import odysseus.Builder;
import odysseus.Kabasuji;
import odysseus.common.entities.Board;
import odysseus.common.entities.Square;

public class MoveSquareTypeMoveRelease extends Move {
	Board board;
	Square square;
	
	public MoveSquareTypeMoveRelease(Board board, Square square){
		this.board = board;
		this.square = square;
	}
	
	/**
	 * If the move is valid remove it from its original location in the board and place it 
	 * in the new location.
	 * 
	 * @return False -if the move is invalid. Otherwise returns true.
	 */
	@Override
	public boolean doMove(Kabasuji game) {
		if(!valid(game)){return false;}
		// TODO
		// Change the type of piece to/from a releaseSquare
		if(square.getType() == "release"){
			board.changeSquare(square);
		} else{
			board.changeToReleaseSquare(square);
		}
		return true;
	}

	/**
	 * Undoes any previous Board to Board Moves.
	 * 
	 * @return True- if move was successfully undo. 
	 */
	@Override
	public boolean undo(Kabasuji game) {
		return doMove(game);
	}

	/**
	 * Iterates through the piece's squares to the corresponding board
	 * to check if any piece-squares are moving to invalid board-squares.
	 * 
	 * @return False - If any squares overlap which should not. Otherwise returns true.
	 */
	@Override
	// The move is only valid if the user is inside of the builder
	public boolean valid(Kabasuji game) {
		if(game instanceof Builder){
			return true;
		}
		return false;
	}
}
