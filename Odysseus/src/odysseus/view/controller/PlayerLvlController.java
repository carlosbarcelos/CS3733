package odysseus.view.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import odysseus.common.entities.Model;
import odysseus.common.entities.Piece;
import odysseus.common.entities.Puzzle;
import odysseus.view.Frames.PlayerLevelP;
import odysseus.view.Frames.PlayerPLvl;

/**
 * Allows player to move from the puzzle level select to a puzzle level.
 * @author valente
 *
 */
public class PlayerLvlController implements ActionListener {
	Model m;
	Puzzle model;
	PlayerLevelP one;
	int numLevel;
	Puzzle p;
	/** Set of pieces. */
	List<Piece> set;

	/** Which piece is selected. */
	Piece selected = null;

	/** Puzzle being solved. */
	Puzzle puzzle;

	/** Placed pieces, with their coordinates. */
	List<Piece> placedPieces = new ArrayList<Piece>();

	/** A piece is being actively floated around (but not already on the board). Not yet in placedPieces. */
	Piece activePiece;

	/** A piece was on the board and is being dragged around. This piece is in placedPieces. */
	Piece draggingPiece;
	public PlayerLvlController (PlayerLevelP o, Puzzle model2,  int numLevel) {
		this.one = o;
		model = model2;
		this.numLevel = numLevel;
	}

	/**
	 * Switch the Puzzle level select to the appropriate level.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Load the given level; if the level does not exist, catch the NullPointer
		try{
			p = (Puzzle) model.loadLevel(numLevel);
		} catch(NullPointerException n){
			System.err.printf("Puzzle level %d not found.", numLevel);
		}

		if(p != null){
			if(p.isUnlocked()){
				// get value
				try {
					int ival  = 17; //Integer.parseInt(one.getTextField().getText());
					one.setVisible(false);

					p.setValue(ival);  // update

					PlayerPLvl two = new PlayerPLvl(p);
					two.setPreviousFrame(one);
					two.setVisible(true);
				} catch (Exception ex) {
					System.err.println("Not Integer!!!");
				}
			}
			else{
				System.err.println("Level not Unlocked!!!");
			}
		}
	}
}