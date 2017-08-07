package odysseus.view.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import odysseus.common.entities.Lightning;
import odysseus.common.entities.Model;
import odysseus.common.entities.Piece;
import odysseus.common.entities.Puzzle;
import odysseus.view.Frames.PlayerLLvl;
import odysseus.view.Frames.PlayerLevelL;

/**
 * Allows player to move from the lightning level select to a lightning level.
 * @author Kevin Valente
 *
 */
public class PlayerLLvlController implements ActionListener {
	Lightning model;
	PlayerLevelL one;
	int numLevel;
	Lightning l;

	public PlayerLLvlController (PlayerLevelL o, Lightning model2, int numLevel) {
		this.one = o;
		this.model = model2;
		this.numLevel = numLevel;
	}

	/**
	 * Switch from the Lightning level select to the corresponding level.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		// Load the given level; if the level does not exist, catch the NullPointer
		try{
			l = (Lightning) model.loadLevel(numLevel);
		} catch(NullPointerException n){
			System.err.printf("Lightning level %d not found.", numLevel);
		}

		if(l != null){
			if(l.isUnlocked()){
				try {
					int ival  = Integer.parseInt(one.getTextField().getText());
					one.setVisible(false);

					l.setValue(ival);  // update

					PlayerLLvl two = new PlayerLLvl(l);
					two.setPreviousFrame(one);
					two.setVisible(true);
				} catch (Exception ex) {
					System.err.println("Not Integer!!!");
				}
			}
		}
	}
}