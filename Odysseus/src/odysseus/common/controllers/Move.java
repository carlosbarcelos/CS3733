package odysseus.common.controllers;

import odysseus.*;

/**
 * The Move super class defines the methods for each particular move.
 * 
 * @author Carlos Barcelos
 *
 */
public abstract class Move {

	protected Move() { }
	
	// Moves can be made given the Kabasuji game
	public abstract boolean doMove (Kabasuji game);
	
	// Moves can be undon given the Kabasuji game
	public abstract boolean undo(Kabasuji game);
	
	// Moves can only be done if they are valid
	public abstract boolean valid (Kabasuji game);
}
