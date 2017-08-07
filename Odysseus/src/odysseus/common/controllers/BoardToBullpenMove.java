package odysseus.common.controllers;

import odysseus.Kabasuji;
import odysseus.common.entities.*;

/**
 * The BoardToBullpenMove moves a piece from the board to the bullpen.
 * 
 * This move simply takes a given piece from the level's board and places it into
 * the level's bullpen.
 * 
 * @author Carlos Barcelos
 */
public class BoardToBullpenMove extends Move {
	Bullpen bullpen;
	Board board;
	Piece target;
	Counter c;

	public BoardToBullpenMove(Bullpen bullpen, Board board, Piece target,Counter c){
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
		if(!valid(game)){return false;}

		// Take the piece from the bullpen and give to board
		board.remove(target);
		bullpen.remove(target);

		// Try to update the counter, if not puzzle, do nothing
		try{
			c.update();
		} catch(NullPointerException n){}
		return false;
	}

	/**
	 * Undoes any previous Board to Board Moves.
	 * 
	 * @return True- if move was successfully undo. 
	 */
	@Override
	public boolean undo(Kabasuji game) {
		if(bullpen.empty()){return false;}

		// Take the piece from the bullpen and give to board
		bullpen.remove(target);
		board.remove(target);

		// An undo will count as a move
		try{
			c.update();
		} catch(NullPointerException n){}
		return false;
	}

	/**
	 * Iterates through the piece's squares to the corresponding board
	 * to check if any piece-squares are moving to invalid board-squares.
	 * 
	 * @return False - If any squares overlap which should not. Otherwise returns true.
	 */
	@Override
	public boolean valid(Kabasuji game) {
		// No piece to return
		if(board.empty()){return false;}

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
