package odysseus.common.controllers;
import java.awt.event.MouseEvent;

import odysseus.Kabasuji;
import odysseus.common.entities.*;

/**
 * The Bullpen controller handles the mouse events associated with the Bullpen.
 * @author Carlos Barcelos
 *
 */
public class BullpenController extends java.awt.event.MouseAdapter {
	Kabasuji game;
	Bullpen bullpen;
	AbsLevel src;
	
	public BullpenController(Kabasuji game, AbsLevel src){
		super();
		this.game = game;
		this.src = src;
		this.bullpen = src.bullpen;
	}
	
	/**
	 * Click the piece multiple times for a specific action.
	 * 	DoubleClick - Rotate piece.
	 * 	TripleClick - Flip piece.
	 */
	public void mouseClicked(MouseEvent me){
		// No pieces to consider
		if(bullpen.empty()){
			return;
		}
		if(me.getClickCount() == 2){
			//TODO Get the piece to be rotated. View thing?			
			Piece piece = bullpen.getPiece(me.getX(), me.getY());
			Piece rotatePiece = bullpen.remove(piece);
			rotatePiece.rotate();
			bullpen.add(rotatePiece);		
		} else if(me.getClickCount() == 3){
			//TODO Get the piece to be rotated. View thing?
			Piece piece = bullpen.getPiece(me.getX(), me.getY());
			Piece mirrorPiece = bullpen.remove(piece);
			mirrorPiece.rotate();
			bullpen.add(mirrorPiece);	
		}
		
	}
	
	/**
	 * Start a drag event to move the piece onto the board.
	 */
	public void mousePressed(MouseEvent me){
		// No pieces to consider
		if(bullpen.empty()){
			return;
		}
		Move m;
		// Create the move
		if(src instanceof Puzzle){
			Puzzle puzzleSRC = (Puzzle) src;
			m = new BullpenToBoardMove(bullpen, src.board, null, puzzleSRC.counter);
			
		} else{
			m = new BullpenToBoardMove(bullpen, src.board, null, null);
		}
		
		// Do the move - Add to move stack or report and error
		if(m.doMove(game)){
			game.pushMove(m);
		} else{
			System.err.println ("BullpenController::mousePressed(). Unexpected failure selecting piece.");
		}
	}
	
	// Handle a mouseReleased event
	public void mouseReleased(MouseEvent me){
		
	}
}
